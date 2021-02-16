package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import Gauss._

object Main {
  var matrix: ArrayBuffer[ArrayBuffer[Float]] = ArrayBuffer(ArrayBuffer(0.toFloat))
  var triangleMatrix: ArrayBuffer[ArrayBuffer[Float]] = ArrayBuffer(ArrayBuffer(0.toFloat))
  var xVector: ArrayBuffer[Float] = ArrayBuffer[Float]()
  var residualVector: ArrayBuffer[Float] = ArrayBuffer[Float]() //вектор невязки
  var order: ArrayBuffer[Int] = ArrayBuffer[Int]() //массив порядка, т.к. менются столбцы, то хn тоже меняются, нужен для вычисления вектора невязки
  var determinant: Float = 0

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
    residualVector = ArrayBuffer.range(0, n).map(_ => 1.toFloat)
    if (matrix.filter(a => a.size != matrix.size + 1).toList.nonEmpty) throw new Exception("you matrix is bullshit") //checking if matrix is square
    val matrix2 = matrix.map(_.clone()) // make clone of origin matrix
    matrix2.map(a => a.remove(matrix.size)) // reduce B column
    determinant = det(matrix2)
    if (determinant == 0) throw new Exception("you matrix is bullshit") //checking if matrix has roots
    else {
      findTriangleMatrix()
      findSolution()
      findResidual()
    }
  }
}

