package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ReadFromConsole {
  def readMatrix (): Unit = {
    try {
      print("Введи число строк матрицы: ")
      val total = StdIn.readInt()
      println("\nВведите матрицу по строкам:")
      var matrix : ArrayBuffer[ArrayBuffer[Float]] = ArrayBuffer(ArrayBuffer(0.toFloat))
      matrix.clear()
      for (i <-0 until total) {
        matrix += StdIn.readLine().split(" ").map(x => x.toFloat).to[ArrayBuffer]
      }
      Main.matrix = matrix
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing lines to matrix\n\t" + e.getMessage)
    }
  }

}
