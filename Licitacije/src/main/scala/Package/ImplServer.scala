package Package

import java.net.URL
import java.rmi.RemoteException
import java.util.ResourceBundle

import javafx.application.{Application, Platform}
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage
import javafx.scene.control.{Button, TextArea}

import scala.collection.mutable.ListBuffer

class ImplServer extends Application with RemoteServer with Initializable {


  private val WAITINGTIME:Int=10000
  /**
    * Map contains items. Key is itemID, value is item
    */
  private var Items : Map[Int, Item] = Map()
  private var Clients:Map[Int, RemoteClient] = Map()
  /**
    * Map contains subscriptions. Key is clientID
    *       value is list of items of interest
    */
  private var Subscriptions : Map [Int, ListBuffer[Item]] = Map()

  def getSubscriptions():Map [Int, ListBuffer[Item]]=Subscriptions

  def getClients(): Map[Int,RemoteClient]=Clients

  def getItems(): ListBuffer[Item]={
    var itemList:ListBuffer[Item]=ListBuffer()
    for(item<-Items.values){
      itemList+=item
    }
    itemList
  }

  /**
    *
    * @param itemPrice price of item we are putting for licitation
    * @param itemName  name of item we are putting on licitation
    * @param clientID  id of client that is making licitation
    * @param time number of minutes until the end of licitation
    * @throws RemoteException
    * @return return id of item wen server makes one
    */
  override def createLicitation(itemPrice: Double, itemName: String, time: Int, clientID: Int): Int = {
    val item : Item = new Item(itemPrice, itemName,time,clientID)
    Items + (item.getID() -> item)
    taText.appendText("New item added\n"+item.toString)
    // improve this
    item.start()
    item.getID()
  }


  /*
  * THIS WILL HAVE PROBLEM FOR SUBSCRIPTIONS
  * EASY FIX IS GOING THROUGH ALL THE SUBSCRIPTIONS AND REMOVING ITEM
  * */
  override def processEndOfLicitation(itemID: Int): Unit = {
    val item=Items(itemID)
    item.synchronized{
      val winner=Clients(item.getTop1Bidder())
      val second=Clients(item.getTop2Bidder())
      if(winner.buy(item)){
        Items=Items-itemID
      }
      else{
        Thread.sleep(WAITINGTIME)
        if(winner.buy(item)){
          Items=Items-itemID
        }
        else{
          /*offering item t0 second client should be implemented
          if(second.offerItem(item))
            Items=Items-itemID
          else
            NAPRAVITI KOPIJU ITEMA I DODATI U ITEMS

          */
        }
      }

    }
  }

  /**
    *
    * @param itemID   ID of item that we are bidding on
    * @param price    new price we are setting
    * @param clientID ID of client that is making the bid
    * @throws RemoteException
    *                 we might wanna add return value so we can know if bid was successful
    */
  override def bid(itemID: Int, price: Double, clientID: Int): Boolean = {
    try {
      val item = Items(itemID)
      val resultOfBid=item.processBid(price,clientID)
      if(resultOfBid)
        taText.appendText("Client: "+clientID+" successfully bid for item: "+itemID+" for "+price+"rsd")
      else
        taText.appendText("Client: "+clientID+" unsuccessfully bid for item: "+itemID)
      return resultOfBid
    } catch {
      case ex: Exception => {
        println("Exception")
        false
      }
    }

  }

  /**
    * this method will be used only when we are second highest bidder and we don't want to buy item
    *
    * @param itemID id of the item that we are offered to buy
    * @throws RemoteException
    */
  override def cancelTransaction(itemID: Int): Unit = {

  }

  /**
    *
    * @param itemID id of the item we are subscribing to
    * @throws RemoteException
    */
  override def subscribe(clientID: Int, itemID: Int): Unit = {
    val item = Items(itemID)
    //maybe this won't work if clientID does not exist
    //CHECK CHECK CHECK
    Subscriptions(clientID) += item
  }

  override def addClient(clientID: Int,remoteClient: RemoteClient): Unit = {
    Clients + (clientID->remoteClient)
    taText.appendText("New client "+clientID+" just joined\n")
  }

  @FXML  var taText:TextArea = _
  @FXML  var btEND:Button = _

  def openGUI(): Unit = {
    Application.launch()
  }

  override def start(primaryStage: Stage): Unit = {
    val resource=getClass.getResource("ServerGuiLayout.fxml")
    if(resource==null){
      println("NEUSPELO UCITAVANJE FXML")
    }

    val root: Parent = FXMLLoader.load(resource)
    primaryStage.setScene(new Scene(root))
    primaryStage.setTitle("LICITACIJE-SERVER")
    primaryStage.show()
  }

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

    taText.setEditable(false)
    taText.appendText("SERVER IS READY!!\n")
    btEND.setOnAction(_=>Platform.exit())
  }
}