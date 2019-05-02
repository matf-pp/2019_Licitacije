package Package

import java.net.URL
import java.util.ResourceBundle

import javafx.fxml.{FXML, Initializable}
import javafx.scene.control.{Button, Label, TextField}
import javafx.scene.layout.HBox

class ClientGuiController extends Initializable {
  @FXML
  var hbItemsOfInterest:HBox=new HBox()
  @FXML
  var hbMyItems:HBox=new HBox()
  @FXML
  var hbNewItems:HBox=new HBox()
  @FXML
  var tfNewBid:TextField=new TextField()
  @FXML
  var btConfirmBid:Button=new Button()
  @FXML
  var btAddNewItem:Button=new Button()
  @FXML
  var lbBalance:Label=new Label()


  override def initialize(location: URL, resources: ResourceBundle): Unit = {}
}
