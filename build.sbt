enablePlugins(ScalaJSPlugin)

name := "epochjs-scala-js"

version := "0.1"

scalaVersion := "2.11.8"

persistLauncher in Compile := true

persistLauncher in Test := false

libraryDependencies += "org.querki" %%% "jquery-facade" % "1.0-RC6"
libraryDependencies += "com.lihaoyi" %%% "scalarx" % "0.3.2"

jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "2.2.1/jquery.js" minified "jquery.min.js"
jsDependencies += "org.webjars" % "d3js" % "3.5.17" / "d3/3.5.17/d3.js" minified "d3/3.5.17/d3.min.js"
jsDependencies += "org.webjars.bower" % "epoch" % "0.8.4" / "0.8.4/dist/js/epoch.js" minified "epoch.min.js"
skip in packageJSDependencies := false
