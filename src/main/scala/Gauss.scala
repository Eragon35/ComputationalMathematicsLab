package main.scala

import scala.io.StdIn

object Gauss extends App {
  val help = """1 Чтение матрицы из файла
               |2 Ввод матрицы вручную
               |3 Вычисление определителя
               |4 Вывод треугольной матрицы (включая преобразованный столбец В)
               |5 Вывод вектора неизвестных: 𝑥1,𝑥2,…,𝑥𝑛
               |6 Вывод вектора невязок: 𝑟1,𝑟,…,𝑟𝑛""".stripMargin
  // ask to read from file or from console
  println(help)
  while (true) {
    print("\nВведи команду, милок: ")
    ConsoleHandler.handler(StdIn.readLine())

  }
//  read input data
//  check if solution exists
//  if it exists find solution
//  get user ability to exit or ask to show extra information



}

