package main.scala

import Main._

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ConsoleHandler {
  val help: String = """1 Чтение матрицы из файла
               |2 Ввод матрицы из консоли
               |3 Вычисление определителя
               |4 Вывод треугольной матрицы (включая преобразованный столбец В)
               |5 Вывод вектора неизвестных: 𝑥1,𝑥2,…,𝑥𝑛
               |6 Вывод вектора невязок: 𝑟1,𝑟,…,𝑟𝑛
               |7 Вывод количества замен
               |8 Чтение коэффицента матрицы из файла
               |9 Ввод коэффицента матрицы из консоли""".stripMargin

  def handler(line: String): Unit = {
    line.trim match {
      case "1" => print("Введите имя файла: ")
        ReadFromFile.readMatrix(StdIn.readLine().trim)
      case "2" => ReadFromConsole.readMatrix()
      case "3" => print("ОпеределительЖ " + determinant)
      case "4" => showMatrix(triangleMatrix)
      case "5" => for (i <- xVector.indices) println("x" + (i+1) + " = " + xVector(i))
      case "6" => for (i <- residualVector.indices) println("r" + (i+1) + " = " + residualVector(i))
      case "7" => print(s"Количество перестановок = $swapCounter")
      case "8" => print("Введите имя файла: ")
        ReadFromFile.readParam(StdIn.readLine().trim)
      case "9" => ReadFromConsole.readParam()
      case "exit" => sys.exit ()
      case "help" => println(help)
      case "order" => order.foreach(x => print(x + " "))
      case "origin" => showMatrix(matrix)
      case _ => print("Извините простите вы не так поняли я сейчас объясню простите давайте уважать друг друга и дружить")
    }
  }

  def showMatrix(matrix: ArrayBuffer[ArrayBuffer[Float]]):Unit = {
    println("Размер матрицы: " + matrix.size)
    matrix.foreach(a => {
      a.foreach(n => {
        val a = BigDecimal.apply(n.toString) // convert through string 'cause apply(Float) is deprecated
        var str = ""
        if (a.isValidLong) str = a.toString()
        else str = f"$a%1.4f".replace(",", ".")
        print(f" $str%-8s ")
      })
      println()
    })
  }
}
