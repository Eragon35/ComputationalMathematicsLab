package main.scala

import scala.io.Source

object ReadFromFile {

  def readMatrix (fileName: String): Unit = {
//    if (!FileChecker.check(fileName)) return
    try {
      var  total = 0
      for (_ <- Source.fromFile(fileName).getLines()) total += 1
      val matrix = Array.ofDim[Float](total, total + 1)
      var counter = 0
        for (line <- Source.fromFile(fileName).getLines()) {
          matrix(counter) = line.split(" ").map(x => x.toFloat)
          counter += 1
        }
      Main.matrix = matrix
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file to matrix\n\t" + e.getMessage)
    }
  }

}
