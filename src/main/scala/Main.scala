package main.scala

import scala.io.StdIn

object Main extends App {
  var matrix = Array.ofDim[Float](1,1)

  println(ConsoleHandler.help)
  while (true) {
    print("\nВведи команду, милок: ")
    ConsoleHandler.handler(StdIn.readLine())
  }
//  check if solution exists
//  if it exists find solution
//  get user ability to exit or ask to show extra information



}

