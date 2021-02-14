package main.scala

import scala.io.StdIn

object ReadFromConsole {
  def readMatrix (): Option[Array[Array[Long]]] = {
    try {
      print("Введи число строк матрицы: ")
      val total = StdIn.readInt()
      val matrix = Array.ofDim[Long](total, total + 1)
      for (i <-0 until total) {
        matrix(i) = StdIn.readLine().split(" ").map(x => x.toLong)
      }
      Option(matrix)
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing lines to matrix\n\t" + e.getMessage)
        None
    }
  }

}
