# Argentinian Holidays Producer

Argentinian Holidays Producer is an API that allows you to publish all the argentinian holidays into a Kafka topic.

## Technologies involved in the REST API:
* Java 11
* Spring Boot 2.6.4
* Maven
* Dependencies:
  * Spring web
  * Lombok
  * Spring Data JPA
  * H2
  * Spring for Apache Kafka
  * ModelMapper

### Endpoints
| Method | Url | Description 
| ------ | --- | ----------- | 
| GET    | /api/v1/holidays | Publish argentinian holidays into a Kafka topic | |

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

## Example:
![postman_screenshot](https://user-images.githubusercontent.com/58220611/156942628-b4a30e55-6e54-4c1b-930b-3527362cff60.png)

![consumer_screenshot](https://user-images.githubusercontent.com/58220611/156942631-6a9b8f83-109b-440c-af18-9bbfc902d0a3.png)
