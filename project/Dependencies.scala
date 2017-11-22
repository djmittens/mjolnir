import sbt._
import sbt.Keys._

object Dependencies extends AutoPlugin {
  object autoImport extends FinchDependencies {
    val finchVersion = settingKey[String]("version for the http library")
  }
  import autoImport._

  trait FinchDependencies {
    lazy val Finch = Seq(
      libraryDependencies ++= Seq(
        "com.github.finagle" %% "finch-core" % finchVersion.value,
        "com.github.finagle" %% "finch-circe" % finchVersion.value,
        "io.circe" %% "circe-generic" % "0.9.0-M2"
      )
    )
  }
}