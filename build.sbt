name := """swagger-demo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test,
  "io.swagger" %% "swagger-play2" % "1.5.1",
  "org.webjars" % "swagger-ui" % "2.1.8-M1"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
