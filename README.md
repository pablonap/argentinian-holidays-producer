# Argentinian Holidays Producer

Argentinian Holidays Producer is an API that allows you to publish all the argentinian holidays into a Kafka topic.

## Steps to use it
###### For this project is used kafka 2.13-3.1.0 version.

* Run Zookeeper:
  * bin/zookeeper-server-start.sh config/zookeeper.properties

* Run Kafka broker:
  * bin/kafka-server-start.sh config/server.properties
* Run the application
* Check the topic was created:
  * bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
* Run Kafka consumer:
  * bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic holiday-events
* Send GET request to "/api/v1/holidays"
