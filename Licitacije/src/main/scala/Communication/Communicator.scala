package Communication

//interface for object that can carry Messages but cant read them

trait Communicator extends AutoCloseable{
  def readMessage[T]():Message[T]
  def writeMessage[T](message: Message[T])
  def readObject():Object
  def writeObject(writtenobject: Object)
  def readString():String
  def writeString(text:String)
  def init()
  def flush()
  def reset()
}
