package Package

/**
  * @constructor
  *
  * @param Price price of the item we are making
  * @param Name name of the item we are making
  */
class Item(private var Price : Double = 0,private var Name:String) extends Thread{
  /**
    * unique ID of item
    */
  private var ID : Int = Item.getID()

  /**
    * clientID of top 1 bidder
    */
  private var Top1Bidder : Int = -1

  /**
    * clientID of top 2 bidder
    */
  private var Top2Bidder : Int = -1

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

}
object Item{
  private var ID:Int=0
  def getID():Int={
    ID.synchronized{
      ID+=1
      ID
    }
  }
}
