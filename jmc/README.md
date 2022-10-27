## Micronaut 3.7.2 Documentation

- [User Guide](https://docs.micronaut.io/3.7.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.7.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.7.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


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
