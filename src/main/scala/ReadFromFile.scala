package main.scala

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import Main._

object ReadFromFile {

  def readMatrix (fileName: String): Unit = {
    try {
      FileChecker.check(fileName)
      var  total = 0
      for (_ <- Source.fromFile(fileName).getLines()) total += 1
      initializer(total)
      var matrix : ArrayBuffer[ArrayBuffer[Float]] = ArrayBuffer(ArrayBuffer(0.toFloat))
      matrix.clear()
      var counter = 0
        for (line <- Source.fromFile(fileName).getLines()) {
          matrix += line.split(" ").map(x => x.toFloat).to[ArrayBuffer]
          counter += 1
        }
      Main.matrix = matrix
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file to matrix\n" + e.getMessage)
    }
  }

}
