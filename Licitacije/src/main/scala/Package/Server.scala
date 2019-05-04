package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.rmi.server.UnicastRemoteObject

object Server {

  private val DEFAULTHOST:String="127.0.0.1"
  private val DEFAULTPORT:Int=0
  def main(args : Array[String]) : Unit = {
    var implServer : ImplServer = new ImplServer()
    var serverStub : RemoteServer = UnicastRemoteObject.exportObject(implServer,0).asInstanceOf[RemoteServer]

    var registry : Registry = LocateRegistry.createRegistry(DEFAULTPORT)
    registry.bind("Server", serverStub)
    implServer.openGUI()
  }
}

