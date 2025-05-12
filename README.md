# poc-freemarker-graalvm

Proof Of Concept for Apache FreeMarker and GraalVM

## Requirements

GraalVM 21+

## Just In Time

Build : 

```shell
mvn clean install
```

Run : 

```shell
mvn exec:java -Dexec.mainClass=org.fugerit.java.poc.freemarker.graalvm.FreeMarkerDemo
```

## Ahead Of Time

Build :

```shell
mvn clean install -Pnative
```

Run :

```shell
./target/poc-freemarker-graalvm
```