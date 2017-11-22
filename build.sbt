lazy val mjolnir = (project in file(".")).
  aggregate(`rest-api`)

finchVersion in ThisBuild := "0.16.0-M4"

lazy val `rest-api` = (project in file("rest-api")).
  enablePlugins(ScalaProject).
  settings(
    Finch
  )

//TODO: Add cats to the dependencies
//TODO: Create a simple ping - pong sort of api
//TODO: Add integration tests
//TODO: Add support for native packager with docker
//TODO: Create a runnable image
//TODO: Deploy to kubernetes
//TODO: Add redis support
//TODO: Add MySql support
//TODO: Add Flyway migrations
//TODO: Work on the ui portion of things
//TODO: Add Oauth support
//TODO: Create a readme
