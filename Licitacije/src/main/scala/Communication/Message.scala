package Communication

//interface for Messages that will be sent

trait Message[T] extends Serializable {
  def setbody(body:T)
  def getbody():T
  def setId(id:Int)
  def getId():Int
}
