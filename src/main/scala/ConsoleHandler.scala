package main.scala

import scala.io.StdIn

object ConsoleHandler {

  def handler(line: String): Unit = {
    line.trim match {
    case "1" => //file
    case "2" => //manual read
    case "3" => //show opredelitel
    case "4" => //show triangle matrix
    case "5" => //show vector of x
    case "6" => //show some bullshit
    case "exit" => sys.exit ()
    case _ => println ("Какой-то ты странный, не буду с тобой работать")
    sys.exit ()
  }
  }

}
