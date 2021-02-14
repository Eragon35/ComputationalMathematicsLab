package main.scala

import scala.io.Source

object ReadFromFile {

  def readMatrix (fileName: String): Option[Array[Array[Long]]] = {
    if (FileChecker.check(fileName)) return None
    try {
      var  total = 0
      for (_ <- Source.fromFile(fileName)) total += 1
      val matrix = Array.ofDim[Long](total, total + 1)
      var counter = 0
        for (line <- Source.fromFile(fileName).getLines()) {
          matrix(counter) = line.split(" ").map(x => x.toLong)
          counter += 1
        }
      Option(matrix)
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file to matrix\n\t" + e.getMessage)
        None
    }
  }

}
