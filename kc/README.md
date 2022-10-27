## Micronaut OpenAPIO Client with java-micronaut-client generator

```bash
./gradlew run

./gradlew build
java -jar build/libs/demo-0.1-all.jar --verbose
```

```console
$ ./gradlew run

> Task :run
00:27:53.928 [main] INFO  i.m.context.env.DefaultEnvironment - Established active environments: [cli]
00:27:54.079 [main] INFO  com.example.DemoCommand - entry ...
00:27:54.573 [main] INFO  com.example.DemoCommand - somePet = {"name":"iadaingu","photoUrls":[],"id":null,"category":null,"tags":null,"status":null,"lifespan":null,"age":"P1Y2M3D"}, somePet.agePeriod = P1Y2M3D
00:27:54.573 [main] INFO  com.example.DemoCommand - done ...

BUILD SUCCESSFUL in 1s
6 actionable tasks: 1 executed, 5 up-to-date
```
