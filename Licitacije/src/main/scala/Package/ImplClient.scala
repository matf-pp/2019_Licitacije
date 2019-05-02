package Package

import java.net.URL
import java.util.ResourceBundle

import javafx.application.Application
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage
import scalafx.scene.control.{Button, Label, TextArea, TextField}
import scalafx.scene.layout.{HBox, VBox}

import scala.collection.mutable.ListBuffer

class ImplClient(private var balance:Double) extends Application with RemoteClient with Initializable {

  private var server: RemoteServer = null
  private var MyItems: ListBuffer[Item] = null
  private var ItemsOfInterest: ListBuffer[Item] = null
  private var ID: Int = ImplClient.getID()

  /**
    *
    * @param item what we should buy
    * @throws
    * @return tell us if client successfully bought the item
    */
  override def buy(item: Item): Boolean = {
    balance.synchronized {
      if (item.getPrice() > balance)
        false
      balance -= item.getPrice()
      true
    }
  }

  /**
    *
    * @param item what client is selling
    * @throws
    */
  override def sell(item: Item): Unit = {
    balance.synchronized {
      balance += item.getPrice()
    }
  }

  /**
    * this function provide us with updated items(we want to know their prices)
    *
    * @param items items of interest for client
    * @throws
    */
  override def updatePrices(items: ListBuffer[Item]): Unit = {

    MyItems = items
  }

  override def getID(): Double = ID

  /*
  *
  *   GUI PART
  *
  * */

  @FXML  var vbItemsOfInterest:VBox = _
  @FXML  var vbMyItems:VBox = _
  @FXML  var vbAllItems:VBox = _
  @FXML  var tfNewBid:TextField = _
  @FXML  var btConfirmBid:Button = _
  @FXML  var btAddNewItem:Button = _
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

  private var currently_selected_item:Item=null

  override def initialize(location: URL, resources: ResourceBundle): Unit = {


    btConfirmBid.setOnAction(e=>{
      if(currently_selected_item!=null){
        val price=Double(tfNewBid.getText())
        val bidding_try:Boolean=server.bid(currently_selected_item.getID(),price,ID)
        if(bidding_try)
          taText.setText("BIDDING WAS SUCCESSFUL")
        else
          taText.setText("BIDDING WAS NOT SUCCESSFUL")
      }
    })

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
      hbInformations.getChildren.addAll(lbName,tfName,lbStartingPrice,tfStartingPrice)

      btConfirm.setOnAction(e =>{
        val itemName:String=tfName.getText()
        val itemPrice:Double=Double(tfStartingPrice.getText())
        server.createLicitation(itemPrice,itemName,ID)
      })

      var PopUpScene:Scene=new Scene(PopUpRoot)
      PopUpStage.setScene(PopUpScene)
      PopUpStage.show()

    })

  }
}

object ImplClient{
  private var ID:Int=0
  def getID():Int={
    ID.synchronized{
      ID+=1
      ID
    }
  }
}


