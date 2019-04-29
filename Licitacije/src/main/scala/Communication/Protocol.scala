package Communication

//interface for object that understand messages passed by commmunicator

trait Protocol {
  def conversation()
  def addComunicator(communicator:Communicator)
  def removeCommunicator(communicator:Communicator):Boolean
  def getCommunicator():Communicator
}
