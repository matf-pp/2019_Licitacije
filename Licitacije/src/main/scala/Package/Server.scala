package Package

import java.rmi.registry.{LocateRegistry, Registry}
import java.rmi.server.UnicastRemoteObject

object Server {

  private val DEFAULTHOST:String="127.0.0.1"
  private val DEFAULTPORT:Int=8080
  private val PERIOD=20000 //period for updates on subscribed items
  private val NUMBEROFPERIODS=10// number of periods before we update all of the items
  def main(args : Array[String]) : Unit = {
    if(System.getSecurityManager==null)
      System.setSecurityManager(new SecurityManager())
    val implServer : ImplServer = new ImplServer()
    val serverStub : RemoteServer = UnicastRemoteObject.exportObject(implServer,0).asInstanceOf[RemoteServer]

    val registry : Registry = LocateRegistry.getRegistry()
    registry.bind("Server", serverStub)
    implServer.openGUI()
    var counter=0
    while(true){
      for(_ <-1 to NUMBEROFPERIODS) {
        for ((clientID, items) <- implServer.getSubscriptions()) {
          val clientStub: RemoteClient = registry.lookup(clientID.toString).asInstanceOf[RemoteClient]
          if (clientStub != null)
            clientStub.updatePrices(items)
        }
        Thread.sleep(PERIOD)
      }

      for(clientID<-implServer.getClients()){
        var clientStub:RemoteClient=registry.lookup(clientID.toString).asInstanceOf[RemoteClient]
        if(clientStub!=null)
        clientStub.updateAll(implServer.getItems())
      }

    }

  }
}

