# scalapb-repro
Small repro for scalapb#87

Run via:

    sbt assembly
    spark-submit --master local target/scala-2.10/tlc-assembly-0.0.0.jar
