package main.scala

import scala.collection.mutable.ArrayBuffer
import main.scala.Main._

object Gauss {

  def det(input: ArrayBuffer[ArrayBuffer[Float]]): Float = {
    val matrix = input.map(_.clone())
    var sum: Float = 0
    if (matrix.size < 3) {
      if (matrix.size == 1) sum += matrix(0)(0)
      else sum += matrix(0)(0) * matrix(1)(1) - matrix(0)(1) * matrix(1)(0)
    }
    else {
      for (i <- matrix.indices) {
        val reducing = matrix.map(_.clone())
        if (i % 2 == 0) sum += matrix(0)(i) * det(reduceMatrix(reducing, i))
        else sum -= matrix(0)(i) * det(reduceMatrix(reducing, i))
      }
    }
    sum
  }
  def reduceMatrix(array: ArrayBuffer[ArrayBuffer[Float]], i: Int): ArrayBuffer[ArrayBuffer[Float]] = {
    array.remove(0)
    array.map(a => a.remove(i))
    array
  }

  def findTriangleMatrix(): Unit = {
    val solutionMatrix = matrix.map(_.clone())
    for (i <- 0 until solutionMatrix.size-1){
      val max = solutionMatrix(i).map(x => Math.abs(x)).slice(i, solutionMatrix.size).max
      val index = solutionMatrix(i).map(x => Math.abs(x)).indexOf(max) //finding column with higher abs(element)
      swapColumns(solutionMatrix, i, index)
      val originRow = solutionMatrix(i)
      if (solutionMatrix(i)(i) > 0) solutionMatrix(i) = solutionMatrix(i).map(_ / max)
      else solutionMatrix(i) = solutionMatrix(i).map(_ / -max)
      for (j <- i+1 until solutionMatrix.size){
        val multiply = solutionMatrix(j)(i)
        for (k <- i to solutionMatrix.size){
          solutionMatrix(j)(k) = solutionMatrix(j)(k) - multiply * solutionMatrix(i)(k)
        }
      }
      solutionMatrix(i) = originRow
    }

   triangleMatrix = solutionMatrix
  }
  def swapColumns(input: ArrayBuffer[ArrayBuffer[Float]], leftColumn: Int, rightColumn: Int): Unit = {
    val swap = order(leftColumn) // swap columns in order to save the changes
    order(leftColumn) = order(rightColumn)
    order(rightColumn) = swap
    input.foreach(r => { // swap columns in matrix
      val temp = r(leftColumn)
      r(leftColumn) = r(rightColumn)
      r(rightColumn) = temp
    })
  }

  def findSolution(): Unit = {
    for (i <- triangleMatrix.indices.reverse) {
      var sum: Float = triangleMatrix(i)(triangleMatrix.size)
      for (j <- i+1 until triangleMatrix.size) sum -= triangleMatrix(i)(j) * xVector(j)
      xVector(i) = sum / triangleMatrix(i)(i) // use order(i)-1 to put answer on the right place
    }
    val temp = ArrayBuffer.range(0, xVector.size).map(_ => 1.toFloat) // return Xs on the right places
    for (i <-xVector.indices) temp(order(i)-1) = xVector(i)
    xVector = temp
  }

  def findResidual(): Unit = {
    for (i <- matrix.indices) { //lines
      var sum: Float = 0
      for (j <- matrix.indices) {
//        print(matrix(i)(j) + " * " +  xVector(j) + "|")
        sum += matrix(i)(j) * xVector(j)
      }
//      println("|" + matrix(i)(matrix.size) + " - " + sum)
      residualVector(i) = matrix(i)(matrix.size) - sum
    }
  }
}