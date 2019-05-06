package Package

import java.net.URL
import java.util.ResourceBundle
import java.util.concurrent.locks

import javafx.application.Application
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage
import javafx.scene.control.{Button, Label, TextArea, TextField}
import javafx.scene.layout.{HBox, VBox}

import scala.collection.mutable.ListBuffer

class ImplClient extends Application with RemoteClient with Initializable {

  private var balance=ImplClient.DEFAULTBALLANCE
  private var server: RemoteServer = null
  private var MyItems: ListBuffer[Item] = null
  private var ItemsOfInterest: ListBuffer[Item] = null
  private val ID: Int = ImplClient.getID()
  private var AllItems:ListBuffer[Item] = null
  private val balanceLock:locks.Lock=new locks.ReentrantLock()

  /**
    *
    * @param item what we should buy
    * @throws
    * @return tell us if client successfully bought the item
    */
  override def buy(item: Item): Boolean = {
    try{
      balanceLock.lock()
      if (item.getPrice() > balance){
        balanceLock.unlock()
        return false
      }
      balance -= item.getPrice()

      //making message appear in text area about our purchase
      taText.setText("Item Bought!\n"+item.toString)

    }
    catch {
      case e:Throwable => println("problem in buy function with balanceLock")
    }
    finally{
      balanceLock.unlock()
    }
    return true
  }

  /**
    *
    * @param item what client is selling
    * @throws
    */
  override def sell(item: Item): Unit = {
    try{
      balanceLock.lock()
      balance+=item.getPrice()
    }
    catch {
      case e:Throwable => println("problem in sell function with balanceLock")
    }
    finally{
      balanceLock.unlock()
    }
  }

  /**
    * this function provide us with updated items(we want to know their prices)
    *
    * @param items items of interest for client
    * @throws
    */
  override def updatePrices(items: ListBuffer[Item]): Unit = {

    ItemsOfInterest = items

    /*updating GUI*/

    /**
      * when updating GUI we delete all the buttons we had so far and create new ones
      * every new button have event handler connected with item it represent
      * pressing it will change text in text area and will change CurrentlySelectedItem
      */
    vbItemsOfInterest.getChildren.removeAll()
    for(item<-ItemsOfInterest){
      val ItemButton:Button=new Button(item.getName())
      ItemButton.setOnAction(_=>{
        taText.setText(Item.toString)
        CurrentlySelectedItem=item
      })
    }
  }

  override def updateAll(items: ListBuffer[Item]): Unit = {
    AllItems = items

    /*updating GUI*/
    //for explanation look at updatePrices function
    vbAllItems.getChildren.removeAll()
    for(item<-AllItems){
      val ItemButton:Button=new Button(item.getName())
      ItemButton.setOnAction(_=>{
        taText.setText(Item.toString)
        CurrentlySelectedItem=item
      })
    }

  }

  override def getID(): Double = ID

  /*
   *   GUI PART
  */

  @FXML  var vbItemsOfInterest:VBox = _
  @FXML  var vbMyItems:VBox = _
  @FXML  var vbAllItems:VBox = _
  @FXML  var vbMyBids:VBox = _
  @FXML  var tfNewBid:TextField = _
  @FXML  var btConfirmBid:Button = _
  @FXML  var btAddNewItem:Button = _
  @FXML  var btSubscribe:Button = _
  @FXML  var lbBalance:Label = _
  @FXML  var taText:TextArea = _

  override def start(primaryStage: Stage): Unit = {
    val resource=getClass.getResource("ClientGuiLayout.fxml")
    if(resource==null){
      println("NEUSPELO UCITAVANJE FXML")
    }

    val root: Parent = FXMLLoader.load(resource)

    primaryStage.setScene(new Scene(root))
    primaryStage.setTitle("LICITACIJE")
  }

  def openGUI(server: RemoteServer) = {
    this.server = server
    Application.launch()
  }

  private var CurrentlySelectedItem:Item=null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {

    /**
      * this button should take value(Double) from tfNewBid and send Server a message
      * with itemId we are bidding on and value we read
      */
    btConfirmBid.setOnAction(e=>{
      if(CurrentlySelectedItem!=null){
        val price=tfNewBid.getText().toDouble
        val bidding_try:Boolean=server.bid(CurrentlySelectedItem.getID(),price,ID)
        if(bidding_try)
          taText.setText("BIDDING WAS SUCCESSFUL")
        else
          taText.setText("BIDDING WAS NOT SUCCESSFUL")
      }
    })

    /**
      * this button should make popup window with form for creating new item
      * after for is filled in message is sent to Server to create new Licitation
      */
    btAddNewItem.setOnAction(e=>{

      var PopUpStage:Stage=new Stage()

      var PopUpRoot:VBox=new VBox(10)
      var hbInformations:HBox=new HBox(5)
      var btConfirm:Button=new Button()
      PopUpRoot.getChildren.addAll(hbInformations,btConfirm)

      var lbName:Label=new Label("Item Name:")
      var tfName:TextField=new TextField()
      var lbStartingPrice:Label=new Label("Starting Price:")
      var tfStartingPrice:TextField=new TextField()
      //should implement date time input
      var lbEndOfLicitation:Label=new Label("Minutes Untill End: ")
      var tfEndOfLicitation:TextField=new TextField()
      hbInformations.getChildren.addAll(lbName,tfName,lbStartingPrice,tfStartingPrice,lbEndOfLicitation,tfEndOfLicitation)

      btConfirm.setOnAction(e =>{
        val itemName:String=tfName.getText()
        val itemPrice:Double=tfStartingPrice.getText().toDouble
        val numberOfMinutes:Int=tfEndOfLicitation.getText().toInt
        server.createLicitation(itemPrice,itemName,numberOfMinutes,ID)
      })

      var PopUpScene:Scene=new Scene(PopUpRoot)
      PopUpStage.setScene(PopUpScene)
      PopUpStage.show()

    })

    /**
      * this button should send message to server with our id and id of currently selected item
      * and server should subscribe us to this item
      */
    btSubscribe.setOnAction(e=>{
      if(CurrentlySelectedItem!=null){
        server.subscribe(ID,CurrentlySelectedItem.getID())
        ItemsOfInterest+=CurrentlySelectedItem
      }
    })

  }
}

object ImplClient{
  private val DEFAULTBALLANCE:Double=1000
  private var ID:Int=0
  private val idLock:locks.Lock=new locks.ReentrantLock()
  def getID():Int={
    try{
      idLock.lock()
      ID+=1
    }
    catch {
      case e:Throwable=>println("problem with idLock!")
    }
    finally {
      idLock.unlock()
    }
    ID
  }
}


