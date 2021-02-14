package main.scala

import scala.collection.mutable.ArrayBuffer

object Gauss {

  def det(input: ArrayBuffer[ArrayBuffer[Float]]): Float = {
    val matrix = input.map(_.clone())
    var sum: Float = 0
    if (matrix.size < 3) {
      if (matrix.size == 1) sum += matrix(0)(0)
      else sum += matrix(0)(0) * matrix(1)(1) - matrix(0)(1) * matrix(1)(0)
    }
    else {

      for (i <- 0 until matrix.size) {
        val reducing = matrix.map(x => x.clone())
        if (i % 2 == 0) sum += matrix(0)(i) * det(reduceMatrix(reducing, i))
        else sum -= matrix(0)(i) * det(reduceMatrix(reducing, i))
      }

    }
    sum
  }

  def findSolution() = {}
  def reduceMatrix(array: ArrayBuffer[ArrayBuffer[Float]], i: Int): ArrayBuffer[ArrayBuffer[Float]] = {
    array.remove(0)
    array.map(a => a.remove(i))
    array
  }
}