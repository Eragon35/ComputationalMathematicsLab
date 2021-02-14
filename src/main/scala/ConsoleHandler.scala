package main.scala

import Main.matrix

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
      case "3" => println(Gauss.findDeterminant(matrix.map(a => a.slice(0, a.size))))
      case "4" => //show triangle matrix
      case "5" => //show vector of x
      case "6" => //show some bullshit
      case "exit" => sys.exit ()
      case "show" =>
      case _ => println ("Какой-то ты странный, не буду с тобой работать")
      sys.exit ()
    }


  }

}
