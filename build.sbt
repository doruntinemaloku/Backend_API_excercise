ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """Backend_API_Excersise""",
    libraryDependencies ++= Seq(
      guice
    )
  )

libraryDependencies += "com.auth0" % "java-jwt" % "3.3.0"
