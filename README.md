# Social Rating Calculator

Tested with:
* Java 8
* Maven 3.6.3
* Kafka 2.4.0
* Redis 5.0.7

## To Run Without Docker

Run [Data Collector](https://github.com/yaskovdev/data-collector).

Run Zookeeper and Kafka (if they are not yet running):
```
cd kafka_2.12-2.4.0
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

Run Redis:
```
cd redis-5.0.7
make # if not yet done
src/redis-server
```

Build and run the application:
```
cd social-rating-calculator
mvn clean package -D maven.test.skip
java -jar ./target/*.jar --spring.config.location=classpath:/local.properties
```

You can run Redis CLI using `src/redis-cli` command to fetch data stored in Redis, etc.

## To Run With Docker

See [Social Rating Docker Compose](https://github.com/yaskovdev/social-rating-docker-compose).
