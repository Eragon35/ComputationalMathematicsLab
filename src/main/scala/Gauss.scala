package main.scala

object Gauss {

  def findDeterminant(matrix: Array[Array[Float]]): Float = {
    if (matrix.size == 1) matrix(0)(0)
    if (matrix.size == 2) matrix(0)(0) * matrix(1)(1) - matrix(0)(1) * matrix(1)(0)
    //      TODO: slice matrix as argument
    else {
      var sum = 0
      for (i <- 0 until matrix.size){
        if (i % 2 ==0) sum += matrix(0)(i) * findDeterminant(reduceMatrix(matrix, i))
          else sum -= matrix(0)(i) * findDeterminant(reduceMatrix(matrix, i))
      }
      sum
    }
  }

  def findSolution() = {}
  def reduceMatrix(array: Array[Array[Float]], i: Int): Array[Array[Float]] = {
    array.drop(0)
  }

}