package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.rmi.server.UnicastRemoteObject

object Client {
  val DEFAULTHOST:String="127.0.0.1"
  val DEFAULTPORT:Int=8080
  def main(args: Array[String]): Unit = {
    if(System.getSecurityManager==null)
      System.setSecurityManager(new SecurityManager())
    var implClient:ImplClient=new ImplClient()
    var clientStub:RemoteClient=UnicastRemoteObject.exportObject(implClient,0).asInstanceOf[RemoteClient]

    var registry:Registry=LocateRegistry.getRegistry()
    registry.bind(implClient.getID().toString,clientStub)

    var server:RemoteServer=registry.lookup("Server").asInstanceOf[RemoteServer]
    server.addClient(implClient.getID())
    implClient.openGUI(server)
  }
}

