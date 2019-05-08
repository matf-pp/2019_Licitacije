package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.util.concurrent.locks

/**
  * @constructor
  *
  * @param Price price of the item we are making
  * @param Name name of the item we are making
  * @param NumberOfMinutes number of minutes until the end of the licitation
  * @param OwnerID ID of the owner(creator of the licitation)
  *
  */
class Item(private var Price : Double = 0,private var Name:String, private var NumberOfMinutes:Int,private var OwnerID: Int) extends Thread with Serializable {
  /**
    * unique ID of item
    */
  private var ID : Int = Item.getID()
  private val StartingPrice:Double=Price

  /**
    * clientID of top 1 bidder
    */
  private var Top1Bidder : Int = -1

  /**
    * clientID of top 2 bidder
    */
  private var Top2Bidder : Int = -1

  def getStartingPrice():Double=StartingPrice

  /**
    * Price getter
    * @return Unit
    */
  def getPrice():Double = Price

  /**
    * ID getter (ID is make statically)
    * @return Unit
    */
  def getID() : Int = ID

  /**
    * Name getter
    * @return
    */
  def GetName():String=Name

  /**
    * Top1Bidder getter
    * @return Unit
    */
  def getTop1Bidder() : Int = Top1Bidder

  /**
    * Top1Bidder getter
    * @return Unit
    */
  def getTop2Bidder() : Int = Top2Bidder

  /**
    * Price setter
    * @param price price to set to
    */
  def setPrice(price: Double) : Unit = {
    this.Price = price
  }

  /**
    * Top1Bidder setter
    * @param clientID clientID of Top1Bidder
    */
  def setTop1Bidder(clientID : Int) : Unit = {
    Top1Bidder = clientID
  }

  /**
    * Top2Bidder setter
    * @param clientID clientID of Top2Bidder
    */
  def setTop2Bidder(clientID : Int) : Unit = {
    Top2Bidder = clientID
  }

  /**
    * Setting new price for item, updating Top1Bidder with new bidder
    * setting Top2Bidder to old Top1Bidder
    * @param price price to set to
    * @param clientID new Top1Bidder
    */
  def updatePrice(price: Double, clientID: Int) : Unit = {
    setPrice(price)
    setTop2Bidder(Top1Bidder)
    setTop1Bidder(clientID)
  }

  def processBid(price:Double,clientID:Int):Boolean={
    this.synchronized{
      if(Price>price)
        false
      setPrice(price)
      setTop2Bidder(Top1Bidder)
      setTop1Bidder(clientID)
    }
    true

  }



  //when Item is created his thread will start and we will wait NumberOfMinutes minutes
  //before we dicide what to do with it
  override def run(): Unit = {
    Thread.sleep(60*1000*NumberOfMinutes)
    val registry:Registry=LocateRegistry.getRegistry()
    val server:RemoteServer=registry.lookup("server").asInstanceOf[RemoteServer]
    server.processEndOfLicitation(this.getID())
  }

  override def toString: String = {
    "Name: "+Name+"\nPrice: "+Price.toString+"\nLicitation end in: "+NumberOfMinutes.toString+" minutes"
  }

}
object Item{
  private var ID:Int=0
  private val idLock:locks.Lock=new locks.ReentrantLock()

  def getID():Int={
    idLock.lock()
    ID+=1
    idLock.unlock()
    ID

  }
}
