This is a small test suite for running Virtual Threads on the modern Java 21 and Spring Boot 3.2

## How to run

`mvn clean install`

## Where to find the results

`./target/gatling/virtualthreadssimulation-*`

## How to switch Virtual Threads on and off

Please check the `application.properties`:

This is the default config with Virtual Threads from the Spring Boot config:

```
spring.threads.virtual.enabled=true
spring.threads.virtual.enabled.manually=false
```

This is the config for manually tuned threads:

```
spring.threads.virtual.enabled=false
spring.threads.virtual.enabled.manually=true
```

This is the config for enabling the simple platform threads:

```
spring.threads.virtual.enabled=false
spring.threads.virtual.enabled.manually=false
```

## Where to find the actual test scenario

`./src/test/scala/gatling/basic/VirtualThreadSimulation.scala`

## How to tune Gatling properties:

`./src/test/resources/gatling.conf`

## Prerequisites

You need to install:

- Java 21 (tested on Liberica JDK 21.0.1 LTS)
- Maven (tested on the version 3.9.6)

Internally it uses:

- Spring Boot 3.2
- Gatling 3.9 
- Scala 2.13 
- You don't need to install any of these libs

# Inspiration

I got the initial idea on how to run Gatling tests [from this repo](https://github.com/amithimani/virtual_threads.git). Thank you, @amithimani!
