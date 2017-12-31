
lazy val `mjolnirZOMGName` = (project in file(".")).
  settings(
    publishArtifact := false,
    publish in Docker := {}
  ).
  aggregate(`rest-api`)

organization in ThisBuild := "me.ngrid"

cancelable := true

twitterServerVersion in ThisBuild := "17.10.0"
finagleVersion in ThisBuild := "17.10.0"
finchVersion in ThisBuild := "0.16.0-M4"
catsVersion in ThisBuild := "1.0.0-RC1"

lazy val `rest-api` = (project in file("rest-api")).
  enablePlugins(
    ScalaProject,
    JavaServerAppPackaging,
    AshScriptPlugin).
  settings(
    dockerBaseImage := "openjdk:8-alpine",
    dockerUsername := Some("djmittens"),
    publishArtifact := false,
    dockerAlias := com.typesafe.sbt.packager.docker.DockerAlias(
      registryHost = None,
      username = dockerUsername.value,
      name = "mjolnir",
      tag = Some(
        name.value + "-" + version.value
      )
    ),
    dockerExposedPorts := Seq(8080, 9990),
    TwitterServer, Finch, CatsAll,
    FinagleAll
  )

