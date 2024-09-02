Creating Kafka Producer and Consumer with Spring Boot

1. Kafka Setup

    - Download Kafka from https://kafka.apache.org/downloads (Scala 2.13)
    - Extract the file in C drive with shortest path (as windows has restriction on path lenght, linux is prefered for kafka)
    - To run Kafka, open comand prompt and run the prompts (to start kafka, zookeeper needs to be run 1st)
      1. For Windows 
       ```shell
        .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
        .\bin\windows\kafka-server-start.bat .\config\server.properties
        ```
      2. For Linux
       ```shell
        bin/windows/zookeeper-server-start.sh config/zookeeper.properties
        bin/windows/kafka-server-start.sh config/server.properties
       ```

2. Creating Kafka Producer with Spring Boot

    - Create a Spring Boot Web project with Kafka dependency
    - Add kafka configuration
    - The request sent can be verified in console and also in command prompt
      1. For windows
       ```shell
        .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic myTopic
       ```
       2. For Linux
       ```shell
        bin/windows/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myTopic
       ```
3. Creating Kafka Consumer with Spring Boot

    - Add kafka configuration
    - The response received can be verified in console and also in command prompt with the same above prompt

4. Serializer and Deserializer
   
   - Serializer and Deserializer can change, so it is better to use external serializer and deserializer
   - Add dependency for 'gson'
   - This also allows to get for multiple topics