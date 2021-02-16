package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import Main._

object ReadFromFile {
  def readMatrix (fileName: String): Unit = {
    try {
      val source = Source.fromFile(fileName)
      FileChecker.check(fileName)
      var matrix : ArrayBuffer[ArrayBuffer[Float]] = ArrayBuffer(ArrayBuffer(0.toFloat))
      matrix.clear()
      for (line <- source.getLines()) matrix += line.split(" ").map(x => x.toFloat).to[ArrayBuffer]
      Main.matrix = matrix
      initializer(matrix.size)
      source.close()
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file to matrix\n" + e.getMessage)
    }
  }
}
