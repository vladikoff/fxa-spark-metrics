import com.github.nscala_time.time.Imports._

import org.apache.spark.{SparkContext,SparkConf}

import com.datastax.spark.connector._
import org.joda.time.DateTime

object DataMigration {

  case class FoodToUserIndex(food: String, user: String)

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf(true).set("spark.cassandra.connection.host", "127.0.0.1")
    val sc = new SparkContext("local", "retgraph", conf)
    val arrayList = new java.util.ArrayList[String]()
    val pastDate = DateTime.now - 2.months

    var a = 0
    for( a <- 1 to 7){
      arrayList.add((pastDate + a.day).toString("yyyy-MM-dd"))
    }

    val rdd = sc.cassandraTable("retgraph", "events").select("uid").where("bucket in ?", arrayList)
    rdd.collect().foreach(println)
  }

}
