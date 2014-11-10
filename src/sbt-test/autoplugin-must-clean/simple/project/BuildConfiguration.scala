import sbt._
import si.urbas.sbt._

object BuildConfiguration extends Build {
  val root = project.in(file("."))
    .enablePlugins(CleanAutoPluginBug)
}