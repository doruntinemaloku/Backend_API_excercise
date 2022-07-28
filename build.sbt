ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """Backend_API_Excersise""",
    libraryDependencies ++= Seq(
      javaJdbc,
      guice,
      ehcache,
      javaJdbc,
      filters,
      "org.mongodb" % "mongodb-driver-sync" % "4.3.0",
      "com.auth0" % "java-jwt" % "3.3.0",
      "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "2.2.0",
    )
  )


