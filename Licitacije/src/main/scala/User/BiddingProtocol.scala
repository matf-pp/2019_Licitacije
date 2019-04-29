package User

import Communication.{Communicator, Message, Protocol}

class BiddingProtocol(communicator: Communicator) extends Protocol{

  override def conversation(): Unit = {
    var communicator=getCommunicator()


  }

  override def addComunicator(communicator: Communicator): Unit = {

  }

  override def removeCommunicator(communicator: Communicator): Boolean = true

  override def getCommunicator(): Communicator = this.communicator
}
