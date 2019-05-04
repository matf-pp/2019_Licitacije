package Package

import java.rmi.{Remote, RemoteException}

import scala.collection.mutable.ListBuffer

trait RemoteClient extends Remote{

  /**
    *
    * @param item what we should buy
    * @throws
    * @return tell us if client successfully bought the item
    */
  @throws[RemoteException]
  def buy(item: Item):Boolean

  /**
    *
    * @param item what client is selling
    * @throws
    */
  @throws[RemoteException]
  def sell(item: Item)

  /**
    * this function provide us with updated items(we want to know their prices)
    *
    * @param items items of interest for client
    * @throws
    */
  @throws[RemoteException]
  def updatePrices(items:ListBuffer[Item])

  @throws[RemoteException]
  def getID():Double
}
