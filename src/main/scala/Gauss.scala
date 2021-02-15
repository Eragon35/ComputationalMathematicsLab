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

  def findSolution(input: ArrayBuffer[ArrayBuffer[Float]]): Unit = {
    val solutionMatrix = input.map(_.clone())
    for (i <- 0 until solutionMatrix.size-1){
      val max = solutionMatrix(i).map(x => Math.abs(x)).slice(0, solutionMatrix.size).max
      val index = solutionMatrix(i).map(x => Math.abs(x)).indexOf(max) //finding column with higher asb(element)
      swapColumns(solutionMatrix, i, index)

//      println("\nBegging " + i + " max " + max)
      val originRow = solutionMatrix(i)
      solutionMatrix(i) = solutionMatrix(i).map(_ / max)

      for (j <- i+1 until solutionMatrix.size){
        val multiply = solutionMatrix(j)(i)
        for (k <- i to solutionMatrix.size){
          solutionMatrix(j)(k) = solutionMatrix(j)(k) - multiply * solutionMatrix(i)(k)
        }
      }
      solutionMatrix(i) = originRow
//      ConsoleHandler.showMatrix(solutionMatrix)
    }
   triangleMatrix = solutionMatrix
  }

  def swapColumns(input: ArrayBuffer[ArrayBuffer[Float]], leftColumn: Int, rightColumn: Int): Unit = {
//    original was .map
    input.foreach(r => {
      val temp = r(leftColumn)
      r(leftColumn) = r(rightColumn)
      r(rightColumn) = temp
    })
  }
}