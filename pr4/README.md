OrderSystem multi-module sample
===============================

Modules:
- order.processing: Product classes and OrderProcessor
- order.storage: OrderStorage
- order.threading: ThreadManager
- order.app: Main application (uses JavaFaker)

Build with Maven:
  mvn -T1C -pl order.app -am clean package

Then run:
  java -p order.app/target/order.app-1.0-SNAPSHOT.jar;order.processing/target/order.processing-1.0-SNAPSHOT.jar;order.storage/target/order.storage-1.0-SNAPSHOT.jar;order.threading/target/order.threading-1.0-SNAPSHOT.jar -m order.app/com.example.order.app.Main

Note: Lombok is used in order.processing; enable annotation processing in your IDE.
