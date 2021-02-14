package main.scala

import scala.io.StdIn

object ReadFromConsole {
  def readMatrix (): Unit = {
    try {
      print("Введи число строк матрицы: ")
      val total = StdIn.readInt()
      println("\nВведите матрицу по строкам:")
      val matrix = Array.ofDim[Float](total, total + 1)
      for (i <-0 until total) {
        matrix(i) = StdIn.readLine().split(" ").map(x => x.toFloat)
      }
      Main.matrix = matrix
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing lines to matrix\n\t" + e.getMessage)
    }
  }

}
