import com.trueaccord.scalapb.{ScalaPbPlugin => PB}

name := "tlc"

version := "0.0.0"

scalaVersion := "2.10.6"

PB.protobufSettings

libraryDependencies += ("org.apache.spark" %% "spark-core" % "1.6.0" % "provided")
libraryDependencies += ("org.apache.spark" %% "spark-sql" % "1.6.0" % "provided")
//libraryDependencies += ("org.apache.spark" %% "spark-core" % "1.6.0").
//  // See https://github.com/sbt/sbt-assembly#exclude-specific-transitive-deps
//  exclude("org.mortbay.jetty", "servlet-api").
//  exclude("commons-beanutils", "commons-beanutils-core").
//  exclude("commons-collections", "commons-collections").
//  exclude("commons-logging", "commons-logging").
//  exclude("com.esotericsoftware.minlog", "minlog").
//  exclude("com.google.guava", "guava").
//  exclude("org.apache.hadoop", "hadoop-yarn-api")

mainClass in Compile := Some("com.sidewalklabs.TlcConverter")
