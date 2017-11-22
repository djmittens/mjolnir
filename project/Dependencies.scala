import sbt._
import sbt.Keys._

object Dependencies extends AutoPlugin {

  object autoImport
    extends FinchDependencies
      with CatsDependencies
      with TwitterDependencies {
    val finchVersion = settingKey[String]("version of the http library")
    val catsVersion = settingKey[String]("version of fp programming library")
    val twitterServerVersion = settingKey[String]("version of the server appliance")
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

  trait CatsDependencies {
    lazy val Cats = libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % catsVersion.value,
      "org.typelevel" %% "cats-macros" % catsVersion.value,
      "org.typelevel" %% "cats-kernel" % catsVersion.value,
    )
  }

  trait TwitterDependencies {
    lazy val TwitterServer =
      libraryDependencies += "com.twitter" %% "twitter-server" % twitterServerVersion.value
  }

}