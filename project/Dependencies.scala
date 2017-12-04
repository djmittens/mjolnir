import sbt.{Def, _}
import sbt.Keys._

object Dependencies extends AutoPlugin {

  object autoImport
    extends FinchDependencies
      with CatsDependencies
      with FinagleDependencies
      with TwitterDependencies {
    val finchVersion = settingKey[String]("version of the http library")
    val catsVersion = settingKey[String]("version of fp programming library")
    val finagleVersion = settingKey[String]("version of the service framework")
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
    def Cats(module: String): Def.Setting[Seq[ModuleID]] =
     libraryDependencies += "org.typelevel" %% s"cats-$module" % catsVersion.value

    lazy val CatsAll = Seq(
      Cats("core"), Cats("macros"), Cats("kernel")
    )
  }

  trait TwitterDependencies {
    lazy val TwitterServer =
      libraryDependencies += "com.twitter" %% "twitter-server" % twitterServerVersion.value
  }

  trait FinagleDependencies {
    def Finagle(module: String): Def.Setting[Seq[ModuleID]] =
     libraryDependencies += "com.twitter" %% s"finagle-$module" % finagleVersion.value

    lazy val FinagleAll = Seq(
      Finagle("core"),
      Finagle("stats"),
      Finagle("mysql"),
      Finagle("redis")
    )
  }
}