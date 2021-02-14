package main.scala

object Gauss {

  def findDeterminant(matrix: Array[Array[Float]]):Float = {
    if (matrix.size == 1) matrix(0)(0)
    if (matrix.size == 2) matrix(0)(0) * matrix(1)(1) - matrix(0)(1) * matrix(1)(0)
//      TODO: slice matrix as argument
    else matrix(0).map(e => e * findDeterminant(matrix.slice(1, matrix.size).map(a => a.slice(1, a.size)))).sum
  }
}
