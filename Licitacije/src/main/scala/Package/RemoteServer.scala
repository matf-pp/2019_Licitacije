package Package

import java.rmi.{Remote, RemoteException}

trait RemoteServer extends Remote{

  /**
    *
    * @param itemPrice price of item we are putting for licitation
    * @param itemName name of item we are putting on licitation
    * @param time number of minutes until the end of licitation
    * @param clientID id of client that is making licitation
    * @throws
    * @return return id of item wen server makes one
    */
  @throws[RemoteException]
  def createLicitation(itemPrice:Double, itemName:String, time:Int, clientID: Int):Int

  /**
    *
    * @param itemID ID of item that we are bidding on
    * @param price new price we are setting
    * @param clientID ID of client that is makeing the bid
    *
    *                 we might wanna add return value so we can know if bid was successful
    */
  @throws[RemoteException]
  def bid(itemID: Int,price: Double, clientID: Int) : Boolean

  /**
    *  this method will be used only when we are second highest bidder and we dont want to buy item
    * @param itemID id of the item that we are offered to buy
    * @throws
    */
  @throws[RemoteException]
  def cancelTransaction(itemID:Int)

  /**
    *
    * @param itemID id of the item we are subscribing to
    * @throws
    */
  @throws[RemoteException]
  def subscribe(clientID: Int, itemID:Int)

  /**
    *
    * @param clientID
    * @param remoteClient
    * @throws
    */
  @throws[RemoteException]
  def addClient(clientID:Int,remoteClient: RemoteClient)

  @throws[RemoteException]
  def processEndOfLicitation(itemID:Int)
}
