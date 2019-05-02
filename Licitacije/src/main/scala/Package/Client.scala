package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.rmi.server.{RemoteServer, UnicastRemoteObject}

object Client {
  val DEFAULTBALLANCE:Double=1000
  def main(args: Array[String]): Unit = {
    var implClient:ImplClient=new ImplClient(DEFAULTBALLANCE)
    var clientStub:RemoteClient=UnicastRemoteObject.exportObject(implClient,0).asInstanceOf[RemoteClient]

    var registry:Registry=LocateRegistry.getRegistry()
    registry.bind(implClient.getID().toString,clientStub)

    var server:RemoteServer=registry.lookup("Server").asInstanceOf[RemoteServer]
    implClient.openGUI(server)
  }
}

