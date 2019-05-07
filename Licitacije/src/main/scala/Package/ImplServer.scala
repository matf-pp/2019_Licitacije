package Package

import java.net.URL
import java.rmi.RemoteException
import java.util.ResourceBundle

import javafx.application.Application
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage
import javafx.scene.control.{Button, TextArea}

import scala.collection.mutable.ListBuffer

class ImplServer extends Application with RemoteServer with Initializable {
  /**
    * Map contains items. Key is itemID, value is item
    */
  private var Items : Map[Int, Item] = Map()
  private var Clients: ListBuffer[Int] = ListBuffer()
  /**
    * Map contains subscriptions. Key is clientID
    *       value is list of items of interest
    */
  private var Subscriptions : Map [Int, ListBuffer[Item]] = Map()

  def getSubscriptions():Map [Int, ListBuffer[Item]]=Subscriptions

  def getClients(): ListBuffer[Int]=Clients

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
    // improve this
    item.getID()
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
      item.synchronized {
        val highestBidPrice = item.getPrice()
        if (highestBidPrice < price) {
          item.updatePrice(price, clientID)
          return true
        }
        false
      }
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

  override def addClient(clientID: Int): Unit = {
    Clients+=clientID
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
  }
}