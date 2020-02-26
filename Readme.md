# Spring cloud stream + kafka binder


Download `Apache Kafka` from here: https://kafka.apache.org/downloads


### Step #1: Start zookeeper server at port 2181

Linux/MacOS Command: 
bin/zookeeper-server-start.sh config/zookeeper.properties

Windows Command: 
bin/zookeeper-server-start.bat config/zookeeper.properties

### Step #2: Start kafka server

Linux/MacOS Command: 
bin/kafka-server-start.sh config/server.properties

Windows Command: 
bin/kafka-server-start.bat config/server.properties

### Step #3: Create a topic

Linux/MacOS Command: 

````
./bin/kafka-topics.sh --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --create --topic demo
````

Windows Command: 

````
bin\kafka-topics.bat --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --create --topic demo
````

### Step #4: Verify the list of topics created

Linux/MacOS Command: 

````
./bin/kafka-topics.sh --zookeeper localhost:2181 --list
````

Windows Command: 

````
bin\kafka-topics.bat --zookeeper localhost:2181 --list
````

Produce a message
-----------------
Linux/MacOS Command: 

````
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic demo
````

Windows Command: 

````
bin\kafka-console-producer.bat --broker-list localhost:9092 --topic demo
````

Consume a message
-----------------
Linux/MacOS Command: 

````
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic demo
````

Windows Command: 

````
bin\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic demo
````