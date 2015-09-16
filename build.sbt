name := "fxa-spark-metrics"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.3.0"
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" %  "1.3.0" withSources() withJavadoc()
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.2.0"
