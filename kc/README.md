## Micronaut OpenAPIO Client with java-micronaut-client generator

```bash
./gradlew run

./gradlew build
java -jar build/libs/demo-0.1-all.jar --verbose
```

```console
$ ./gradlew run

> Task :run
23:37:03.759 [main] INFO  i.m.context.env.DefaultEnvironment - Established active environments: [cli]
23:37:03.930 [main] INFO  com.example.DemoCommand - entry ...
23:37:04.424 [main] INFO  com.example.DemoCommand - somePet = {"name":"iadaingu","photoUrls":[],"id":null,"category":null,"tags":null,"status":null}
23:37:04.424 [main] INFO  com.example.DemoCommand - done ...

BUILD SUCCESSFUL in 2s
6 actionable tasks: 3 executed, 3 up-to-date
```
