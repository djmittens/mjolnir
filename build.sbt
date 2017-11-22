lazy val mjolnir = (project in file(".")).
  aggregate(`rest-api`)

lazy val `rest-api` = (project in file("rest-api")).settings(
  scalaVersion := "2.12.4",
  libraryDependencies ++= Seq(
    "com.github.finagle" %% "finch-core" % "0.16.0-M4",
    "com.github.finagle" %% "finch-circe" % "0.16.0-M4",
    "io.circe" %% "circe-generic" % "0.9.0-M2"
  )
)

