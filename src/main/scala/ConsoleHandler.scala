package main.scala

import Main._

import scala.collection.mutable.ArrayBuffer

object ConsoleHandler {

  val help: String = """1 Чтение матрицы из файла
               |2 Ввод матрицы вручную
               |3 Вычисление определителя
               |4 Вывод треугольной матрицы (включая преобразованный столбец В)
               |5 Вывод вектора неизвестных: 𝑥1,𝑥2,…,𝑥𝑛
               |6 Вывод вектора невязок: 𝑟1,𝑟,…,𝑟𝑛""".stripMargin

  def handler(line: String): Unit = {
    line.trim match {
      case "1" => ReadFromFile.readMatrix("filename")
      case "2" => ReadFromConsole.readMatrix()
      case "3" => val matrix2 = matrix.map(_.clone()) // make clone of origin matrix
        matrix2.map(a => a.remove(matrix2.size)) // reduce B column
        println("Определитель = " + Gauss.det(matrix2))
      case "4" => showMatrix(triangleMatrix)
      case "5" => xVector.foreach(x => print(x + " "))
      case "6" => residualVector.foreach(x => print(x + " "))
      case "exit" => sys.exit ()
      case "show" => showMatrix(matrix)
      case "help" => println(help)
      case "solve" => Gauss.findSolution(matrix)
      case _ => println ("Какой-то ты странный, не буду с тобой работать")
      sys.exit ()
    }
  }

  def showMatrix(matrix: ArrayBuffer[ArrayBuffer[Float]]):Unit = {
    matrix.foreach(a => {
      a.foreach(n => print(n + " "))
      println()
    })
  }
}
