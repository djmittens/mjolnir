lazy val `mjolnirZOMGName` = (project in file(".")).
  aggregate(`rest-api`)

cancelable in ThisBuild := true

twitterServerVersion in ThisBuild := "17.10.0"
finchVersion in ThisBuild := "0.16.0-M4"
catsVersion in ThisBuild := "1.0.0-RC1"

lazy val `rest-api` = (project in file("rest-api")).
  enablePlugins(ScalaProject).
  settings(
    TwitterServer, Finch, Cats
  )

