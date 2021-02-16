package main.scala

import Main._
import _root_.main.scala.Gauss._

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ConsoleHandler {

  val help: String = """1 Чтение матрицы из файла
               |2 Ввод матрицы вручную
               |3 Вычисление определителя
               |4 Вывод треугольной матрицы (включая преобразованный столбец В)
               |5 Вывод вектора неизвестных: 𝑥1,𝑥2,…,𝑥𝑛
               |6 Вывод вектора невязок: 𝑟1,𝑟,…,𝑟𝑛""".stripMargin

  def handler(line: String): Unit = {
    line.trim match {
      case "1" => print("\nВведите имя файла: ")
        ReadFromFile.readMatrix(StdIn.readLine().trim)  // "filename"
      case "2" => ReadFromConsole.readMatrix()
      case "3" => print(determinant)
      case "4" => showMatrix(triangleMatrix)
      case "5" => xVector.foreach(x => print(x + " "))
      case "6" => residualVector.foreach(x => print(x + " "))
      case "7" => print("\nВведите имя файла: ")
        ReadFromFile.readParam(StdIn.readLine().trim)  // "filename"
      case "8" => ReadFromConsole.readParam()
      case "exit" => sys.exit ()
      case "help" => println(help)
      case "order" => order.foreach(x => print(x + " "))
      case "origin" => showMatrix(matrix)
      case "solve" => findTriangleMatrix()
        findSolution()
        findResidual()
      case _ => print("Извините простите вы не так поняли я сейчас объясню простите давайте уважать друг друга и дружить")
    }
  }

  def showMatrix(matrix: ArrayBuffer[ArrayBuffer[Float]]):Unit = {
    matrix.foreach(a => {
      a.foreach(n => print(n + " "))
      println()
    })
  }
}
