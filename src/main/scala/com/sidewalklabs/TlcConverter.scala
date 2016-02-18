package com.sidewalklabs

import com.sidewalklabs.tlc.{SimpleMessage, MessageWithEnum, MyEnum}
import org.apache.hadoop.io.{BytesWritable, SequenceFile}
import org.apache.hadoop.io.compress.GzipCodec
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd._

/**
 * Convert CSV data to proto format.
 */
object TlcConverter {

  val OUTPUT_PATH = "output.parquet"

  def main(args: Array[String]): Unit = {
    val logFile = "logfile" // Should be some file on your system
    val conf = new SparkConf().setAppName("TLC Converter")
    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._

    // This works:
    val messages = sc.parallelize(List(
      SimpleMessage(name=Some("Dan"), value=Some(1.0f)),
      SimpleMessage(name=Some("Nadav"), value=Some(2.0f))
    ))

    // This does not:
    // val messages = sc.parallelize(List(
    //   MessageWithEnum(name=Some("Dan"), typ=Some(MyEnum.A)),
    //   MessageWithEnum(name=Some("Nadav"), typ=Some(MyEnum.B))
    // ))

    messages.toDF().write.parquet(OUTPUT_PATH)
  }
}
