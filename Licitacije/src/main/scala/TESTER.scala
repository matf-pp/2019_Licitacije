import Server.MainServer

object TESTER {
  def main(args: Array[String]): Unit ={
    // ako za port stavimo 0 uvek se napravi port, boga pitaj zasto
    var server= new MainServer(0,"protokol")
    server.start()
    println(":)")
    var input=""
    while(input!="ugasi"){
      input=scala.io.StdIn.readLine("Unesite komandu: ")
      if(input=="napravi klijenta"){

      }
    }
    server.stop()
  }
}
