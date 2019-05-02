package Package

class ImplClient(private var ballance:Double) extends RemoteClient {

  private var MyItemems:List[Item]=null
  private var ItemsOfInterest:List[Item]=null
  private var ID:Int=ImplClient.getID()
  /**
    *
    * @param item what we should buy
    * @throws
    * @return tell us if client successfully bought the item
    */
  override def buy(item: Item): Boolean = {
    ballance.synchronized{
      if(item.getPrice()>ballance)
        false
      ballance-=item.getPrice()
      true
    }
  }

  /**
    *
    * @param item what client is selling
    * @throws
    */
  override def sell(item: Item): Unit = {
    ballance.synchronized{
      ballance+=item.getPrice()
    }
  }

  /**
    * this function provide us with updated items(we want to know their prices)
    *
    * @param items items of interest for client
    * @throws
    */
  override def updatePrices(items: List[Item]): Unit = {
    MyItemems=items

}

object ImplClient{
  private var ID:Int=0
  def getID():Int=
      ID.synchronized{
      ID+=1
      ID
    }
  }
}