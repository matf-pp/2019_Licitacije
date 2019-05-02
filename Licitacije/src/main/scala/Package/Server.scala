package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.rmi.server.UnicastRemoteObject

object Server {

  def main(args : Array[String]) : Unit = {
    var implServer : ImplServer = new ImplServer()
    var serverStub : RemoteServer = UnicastRemoteObject.exportObject(implServer,0).asInstanceOf[RemoteServer]

    var registry : Registry = LocateRegistry.getRegistry()
    registry.bind("Server", serverStub)

    implServer.openGUI()
  }
}

