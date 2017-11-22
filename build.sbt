lazy val `mjolnirZOMGName` = (project in file(".")).
  aggregate(`rest-api`)

cancelable in ThisBuild := true

finchVersion in ThisBuild := "0.16.0-M4"
catsVersion in ThisBuild := "1.0.0-RC1"

lazy val `rest-api` = (project in file("rest-api")).
  enablePlugins(ScalaProject).
  settings(
    Finch,
    Cats
  )

//TODO: Add twitter server
//TODO: Logging and logback
//TODO: Add integration tests
//TODO: Add support for native packager with docker
//TODO: Create a runnable image
//TODO: Deploy to kubernetes
//TODO: Add redis support
//TODO: Add MySql support
//TODO: Add Flyway migrations
//TODO: Work on the ui portion of things
//TODO: Add Oauth support
//TODO: Add metrics
//TODO: Add Ssl
//TODO: Create a readme
