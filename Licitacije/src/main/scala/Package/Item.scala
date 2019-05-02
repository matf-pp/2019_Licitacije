package Package

/**
  * @constructor
  *
  * @param price price of the item we are making
  * @param name name of the item we are making
  */
class Item(private var price:Double=0,private var name:String) extends Thread{
  private var ID=Item.getID()
  def getPrice():Double=price


}
object Item{
  private var ID:Int=0
  def getID():Int={
    ID.synchronized{
      ID+=1
      ID
    }
  }
}
