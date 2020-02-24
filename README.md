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
rm -rf target
mvn clean package
java -jar ./target/social-rating-calculator-*.jar
```

You can specify alternative properties file for the application, e.g.:
```
java -jar ./target/social-rating-calculator-*.jar --spring.config.location=./prod.properties
```

You can run Redis CLI using `src/redis-cli` command to fetch data stored in Redis, etc.
