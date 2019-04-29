package Server

import java.net._

/*

THIS IS ABSTRACT CLASS
METHOD PROCESS REQUEST SHOULD CHANGE DEPENDING WHAT TYPE OF SERVER DO YOU WANT

*/

abstract class Server(var port:Int, var protocol:String) extends Runnable{
  val id=Server.newIdNum
  protected var thread :Thread=null
  protected var running :Boolean=false
  var listner:ServerSocket=null

  def this(){
    this(Server.DEFAULTPORT,Server.DEFAULTPROTOCOL)
  }

  def this(port:Int){
    this(port,Server.DEFAULTPROTOCOL)
  }

  def run={
    listner= new ServerSocket(port)
    while(running){
      try{
        var client = listner.accept()
        processRequest(client)
      }
      catch {
        case socketexception:java.net.SocketException => {
          println("SOKET LISTNER IS CLOSED")
          close()
        }
      }
    }
    close()
  }

  def start() = {
    if (thread==null){
      println("Napravio sam server :)")
      thread =  new Thread(this,"Server")
      running=true
      thread.start()
      println("Napravio sam server :)")
    }
  }
  def stop()=running.synchronized{
    running=false
    thread.interrupt()
    close()
    println("Ugasio sam se")
  }
  def close() = {
    listner.close()
  }

  def processRequest(client:Socket)

}

object Server{
  private var id=0
  private val DEFAULTPROTOCOL = "ServerProtocol"
  private val DEFAULTPORT = -1
  def newIdNum ={id+=1; id}
}