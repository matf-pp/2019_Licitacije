package User

import java.net.Socket

import Items.Item

class User(var balance:Double) {
  var socket=new Socket()
  def this(){
    this(User.DefaultBalance())
  }

  private var id=User.getID()

  def bid(item: Item, price: Double){
    var bidMsg=new BidMessage(new Bid(item,price))


  }
}
object User{
  private var DEFAULTBALANCE:Double=1000
  private var ID=0
  def DefaultBalance():Double=DEFAULTBALANCE
  def getID():Int={
    ID+=1
    ID
  }
}
