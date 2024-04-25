
from pyspark.sql import SparkSession

spark = SparkSession \
        .builder.appName("SimpleApp") \
        .config('spark.jars.packages', 'org.neo4j:neo4j-connector-apache-spark_2.12:5.1.0_for_spark_3') \
        .master("local[3]") \
        .getOrCreate()

# read data from neo4j using spark

df = spark.read.format("org.neo4j.spark.DataSource") \
    .option("url", "bolt://localhost:7687") \
    .option("authentication.type", "basic") \
    .option("authentication.basic.username", "neo4j") \
    .option("authentication.basic.password", "connect") \
    .option("labels", "vehicle") \
    .load()

df.show()


# write data to neo4j using spark

df.write.format("org.neo4j.spark.DataSource") \
    .option("url", "bolt://localhost:7687") \
    .option("authentication.type", "basic") \
    .option("authentication.basic.username", "neo4j") \
    .option("authentication.basic.password", "connect") \
    .option("labels", ":Person") \
    .option("node.keys", "name") \
    .mode("Overwrite") \
    .save()

spark.stop()
