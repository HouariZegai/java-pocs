# Kafka
1. Run ZooKeeper:
```bash
  ./bin/zookeeper-server-start.sh config/zookeeper.properties
```
2. Run Kafka server:
```bash
  ./bin/kafka-server-start.sh config/server.properties
```
3. Run consumer console [optional (for debug & test)]:
```bash
  ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <topic-name>
```
4. Run producer console [optional (for debug & test)]:
```bash
  ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic <topic-name>
```
5. Run producer console for KStream (e.g. on topic: R4)
```bash
  ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic R4 --property print.key=true --property print.value=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
```