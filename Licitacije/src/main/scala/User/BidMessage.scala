package User

import Communication.Message
import Items.Item

class Bid(items: Item,price:Double) extends Serializable{

}

class BidMessage(var bid: Bid) extends Message[Bid]{
  private var id=BidMessage.getId()

  override def setbody(body: Bid): Unit = {
    this.bid=body
  }

  override def getbody(): Bid = this.bid

  override def setId(id: Int): Unit = {
    this.id=id
  }

  override def getId(): Int = id
}

object BidMessage{
  private var id=0
  def getId():Int={
    id+=1
    id
  }
}
