import sbt._
import sbt.Keys._
resolvers += Resolver.sonatypeRepo("releases")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.1")
