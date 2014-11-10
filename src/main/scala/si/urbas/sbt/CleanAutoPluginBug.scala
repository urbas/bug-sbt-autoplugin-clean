package si.urbas.sbt

import sbt.Keys._
import sbt._

object CleanAutoPluginBug extends AutoPlugin {

  object autoImport {
    val testFile = settingKey[File]("just a generated file")
    val generateTestFile = taskKey[Unit]("generates the file")
  }

  import si.urbas.sbt.CleanAutoPluginBug.autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = {
    Seq(
      testFile := sourceDirectory.value / "testfolder" / "testfile",
      generateTestFile := {
        testFile.value.getParentFile.mkdirs()
        IO.write(testFile.value, "Hello world")
      },
      cleanFiles <+= testFile,
      cleanFiles += testFile.value,
      clean := {
        val _ = clean.value
        IO.delete(testFile.value)
      }
    )
  }
}
