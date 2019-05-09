package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.rmi.server.UnicastRemoteObject

object Client {
  def main(args: Array[String]): Unit = {
    if(System.getSecurityManager==null)
      System.setSecurityManager(new SecurityManager())
    var implClient:ImplClient=new ImplClient()
    var clientStub:RemoteClient=UnicastRemoteObject.exportObject(implClient,0).asInstanceOf[RemoteClient]

    var registry:Registry=LocateRegistry.getRegistry(Server.DEFAULTHOST,Server.DEFAULTPORT)
    registry.bind(implClient.getID().toString,clientStub)



    var server:RemoteServer=registry.lookup("Server").asInstanceOf[RemoteServer]
    server.addClient(implClient.getID(),clientStub)

    implClient.openGUI(server)
  }
}

