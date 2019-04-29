package Communication

//library for reflection, =>ru is the same as 'import blabla as bla' in python

import scala.reflect.runtime.{universe=>ru}


/*
* this class is used to make protocols needed for conversations
* we will pass protocol by String and it will make us Protocol object using reflection
*/
class ProtocolFactory() {



  def createProtocol  (protocolName :String):Protocol={
    var protocol:Protocol=null
    val mirror=ru.runtimeMirror(getClass.getClassLoader)
    val classC = ru.typeOf[C].typeSymbol.asClass4444444

    protocol
  }
}
