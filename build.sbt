import sbt.ScriptedPlugin._
import sbt.ScriptedPlugin._

organization := "si.urbas"

name := "bug-sbt-autoplugin-clean"

sbtPlugin := true

scriptedSettings

scriptedLaunchOpts ++= Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)

scriptedBufferLog := false

