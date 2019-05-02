package Package

import java.rmi.RemoteException

import scala.collection.mutable.ListBuffer

class ImplServer extends RemoteServer {
  /**
    * Map contains items. Key is itemID, value is item
    */
  private var Items : Map[Int, Item] = Map()

  /**
    * Map contains subscriptions. Key is clientID
    *       value is list of items of interest
    */
  private var Subscriptions : Map [Int, ListBuffer[Item]] = Map()

  /**
    *
    * @param itemPrice price of item we are putting for licitation
    * @param itemName  name of item we are putting on licitation
    * @param clientID  id of client that is making licitation
    * @throws RemoteException
    * @return return id of item wen server makes one
    */
  override def createLicitation(itemPrice: Double, itemName: String, clientID: Int): Int = {
      val item : Item = new Item(itemPrice, itemName)
      Items + (item.getID() -> item)
      // improve this
      item.getID()
  }

  /**
    *
    * @param itemID   ID of item that we are bidding on
    * @param price    new price we are setting
    * @param clientID ID of client that is makeing the bid
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


}
