package Package

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.stage.Stage

import scala.collection.mutable.ListBuffer

class ImplClient(private var ballance:Double) extends Application with RemoteClient {

  private var server: RemoteServer = null
  private var MyItemems: ListBuffer[Item] = null
  private var ItemsOfInterest: ListBuffer[Item] = null
  private var ID: Int = ImplClient.getID()

  /**
    *
    * @param item what we should buy
    * @throws
    * @return tell us if client successfully bought the item
    */
  override def buy(item: Item): Boolean = {
    ballance.synchronized {
      if (item.getPrice() > ballance)
        false
      ballance -= item.getPrice()
      true
    }
  }

  /**
    *
    * @param item what client is selling
    * @throws
    */
  override def sell(item: Item): Unit = {
    ballance.synchronized {
      ballance += item.getPrice()
    }
  }

  /**
    * this function provide us with updated items(we want to know their prices)
    *
    * @param items items of interest for client
    * @throws
    */

  override def updatePrices(items: List[Item]): Unit = {

    MyItemems = items
  }

  override def start(primaryStage: Stage): Unit = {
    var root: HBox = new HBox()



    var scene: Scene = new Scene(root)
    primaryStage.setScene(scene)
    primaryStage.show()
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

