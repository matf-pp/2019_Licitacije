package Server

import java.net.Socket
import java.util

import User.User

/*
*
* SERVER WILL MAKE NEW THREAD EVERY TIME IT NEEDS TO PROCESS REQUEST
* WE CHOSE THIS IMPLEMENTATION SINCE WE WANT ALL OF THE CUSTOMERS TO HAVE A CHANCE TO BID
*
* */
class MainServer extends Server(){
  def this(port:Int,protocol:String){
    this()
    this.port=port
    this.protocol=protocol
  }
  var useres=new util.ArrayList[User]()


  def processRequest(client:Socket)={
    new WorkingThread(Server.newIdNum, client,protocol).start()
  }

}
