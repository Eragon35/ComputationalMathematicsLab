package main.scala

import java.nio.file.{Files, Path, Paths}

object FileChecker {
  /**
   *
   * @param name name of the file
   * @return true if having some problems otherwise false
   */
  def check(name: String): Boolean = {
    if (name.isEmpty) {
      Console.err.println("\tdude, i need a file's name")
      return true
    }
    val path: Path = Paths.get(name)
    if (!Files.exists(path)){
      Console.err.println("\tdude, file doesn't exist")
      return true
    }
    if(!Files.isReadable(path)) {
      Console.err.println("\tdude, i can't read the file")
      return true
    }
    false
  }
}

