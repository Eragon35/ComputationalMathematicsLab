package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main extends App {
  var matrix = ArrayBuffer(ArrayBuffer(0.toFloat))
  var triangleMatrix = ArrayBuffer(ArrayBuffer(0.toFloat))
  var xVector = ArrayBuffer[Float](0)
  var residualVector = ArrayBuffer[Float](0) //вектор невязки

  println(ConsoleHandler.help)
  while (true) {
    print("\nВведи команду, милок: ")
    ConsoleHandler.handler(StdIn.readLine())
  }
//  check if solution exists
//  if it exists find solution
}

