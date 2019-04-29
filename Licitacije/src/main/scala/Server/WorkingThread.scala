package Server

import java.net.Socket

import Communication.{Communicator, Message, Protocol, ProtocolFactory}

class WorkingThread(var id:Int, var client:Socket,var protocolName:String) extends Thread{

  var pf:ProtocolFactory=new ProtocolFactory()



  override def run(){
    work()
  }

  def getClient(): Socket=client

  def getCommunicator(): Communicator ={
    //THIS IS FAKE NEED TO MAKE IT OK, JUST WAIT UNTILL YOU FIND OUT WHAT YOU WANT HERE
    return null
  }




  var protocol:Protocol=null

  def work()={
    try{
      var communicator:Communicator=getCommunicator()
      protocol=pf.createProtocol(protocolName)
      if(protocol==null){}
      else {
        communicator.init()
        protocol.addComunicator(communicator)
        protocol.conversation()
      }
    }
    catch {
      case _:Throwable => println("well well well look what we have here\n a problem in working thread thats what")
    }

  }
}
