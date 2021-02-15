package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main {
  var matrix = ArrayBuffer(ArrayBuffer(0.toFloat))
  var triangleMatrix = ArrayBuffer(ArrayBuffer(0.toFloat))
  var xVector = ArrayBuffer[Float]()
  var residualVector = ArrayBuffer[Float]() //вектор невязки
  var order = ArrayBuffer[Int](0) //массив порядка, т.к. менются столбцы, то хn тоже меняются, нужен для вычисления вектора невязки

  def main(args: Array[String]): Unit = {
    println(ConsoleHandler.help)
    while (true) {
      print("\nВведи команду, милок: ")
      ConsoleHandler.handler(StdIn.readLine())
    }
  }

  def initializer(n: Int): Unit = {
    order = (1 to n toArray).to[ArrayBuffer]
    xVector = ArrayBuffer.range(0, n).map(_ => 1.toFloat)
    residualVector = ArrayBuffer.range(0, n).map(_ => 0.toFloat)
  }
//  check if solution exists
//  if it exists find solution
}

