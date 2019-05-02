package Package

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.scene.layout.HBox
import javafx.stage.Stage

import scala.collection.mutable.ListBuffer

class ImplClient(private var balance:Double) extends Application with RemoteClient {

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


