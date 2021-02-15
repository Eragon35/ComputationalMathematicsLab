package main.scala

import java.nio.file.{Files, Path, Paths}

object FileChecker {
  def check(name: String): Unit = {
    if (name.isEmpty) {
      throw new Exception("\tdude, i need a file's name")
    }
    val path: Path = Paths.get(name)
    if (!Files.exists(path)){
      throw new Exception("\tdude, file doesn't exist")
    }
    if(!Files.isReadable(path)) {
      throw new Exception("\tdude, i can't read the file")
    }
  }
}

