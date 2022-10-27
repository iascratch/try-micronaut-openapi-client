## Micronaut OpenAPIO Client with kotlin-client generator

```bash
./gradlew run

./gradlew build
java -jar build/libs/demo-0.1-all.jar --verbose
```

```console
$ ./gradlew run

> Task :run
21:59:48.626 [main] INFO  i.m.context.env.DefaultEnvironment - Established active environments: [cli]
21:59:49.131 [main] INFO  com.example.DemoCommand - entry ...
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = Dog 2
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = Special_char_owner_!@#$^&()`.testing
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = 見響见响仮仏!$%&()*+,-ƄƅƆḞḟṀʶʷʸăĄą
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = Danelle
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = null
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = null
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = Анфиса
21:59:49.923 [main] INFO  com.example.DemoCommand - pet.name = bagsi

BUILD SUCCESSFUL in 5s
7 actionable tasks: 1 executed, 6 up-to-date
```
