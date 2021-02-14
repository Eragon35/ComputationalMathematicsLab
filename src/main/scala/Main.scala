package main.scala

import scala.io.StdIn

object Main extends App {
  var matrix = Array.ofDim[Float](1,1)
  var triangleMatrix = Array.ofDim[Float](1,1)
  var xVector = Array[Int](0)
  var residualVector = Array[Int](0) //вектор невязки

  println(ConsoleHandler.help)
  while (true) {
    print("\nВведи команду, милок: ")
    ConsoleHandler.handler(StdIn.readLine())
  }
//  check if solution exists
//  if it exists find solution

}

