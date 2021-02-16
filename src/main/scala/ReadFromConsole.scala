package main.scala

import main.scala.Main._

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ReadFromConsole {
  def readMatrix (): Unit = {
    try {
      print("Введи число неизвестных: ")
      val total = StdIn.readInt()
      println("\nВведите матрицу по строкам:")
      var matrix : ArrayBuffer[ArrayBuffer[Float]] = ArrayBuffer(ArrayBuffer(0.toFloat))
      matrix.clear()
      for (_ <- 0 until total) matrix += StdIn.readLine().trim.split(" ").map(x => x.toFloat).to[ArrayBuffer]
      Main.matrix = matrix
      initializer(total)
    } catch {
      case e: Throwable =>
        Console.err.println("\tProblem with parsing lines to matrix\n\t" + e.getMessage)
        e.printStackTrace()
    }
  }

  def readParam(): Unit = {
    print("Введи строку для изменения: ") // строки и столбцы начинаются с 1
    val x = StdIn.readInt()
    print("Введи столбец для изменения: ")
    val y = StdIn.readInt()
    print("Введи новое значение коэффицента: ")
    val k = StdIn.readInt()
    matrix(x-1)(y-1) = k
    initializer(matrix.size)
  }
}
