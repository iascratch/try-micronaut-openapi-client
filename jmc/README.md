## Micronaut OpenAPIO Client with java-micronaut-client generator

```bash
./gradlew run

./gradlew build
java -jar build/libs/demo-0.1-all.jar --verbose
```

```console
$ ./gradlew run

> Task :compileKotlin
w: /home/iwana/sw/d/gitlab.com/aucampia/try/micronaut-openapi-client/jmc/src/main/kotlin/com/example/DemoCommand.kt: (24, 5): Unsafe use of a nullable receiver of type (Mutable)List<Pet!>?

> Task :run
22:28:22.790 [main] INFO  i.m.context.env.DefaultEnvironment - Established active environments: [cli]
22:28:23.292 [main] INFO  com.example.DemoCommand - entry ...
22:28:23.292 [main] INFO  com.example.DemoCommand - getting sold pets ...
22:28:24.132 [main] INFO  com.example.DemoCommand - pet.name = Dog 2
22:28:24.132 [main] INFO  com.example.DemoCommand - pet.name = Special_char_owner_!@#$^&()`.testing
22:28:24.132 [main] INFO  com.example.DemoCommand - pet.name = 見響见响仮仏!$%&()*+,-ƄƅƆḞḟṀʶʷʸăĄą
22:28:24.133 [main] INFO  com.example.DemoCommand - pet.name = Danelle
22:28:24.133 [main] INFO  com.example.DemoCommand - pet.name = null
22:28:24.133 [main] INFO  com.example.DemoCommand - pet.name = null
22:28:24.133 [main] INFO  com.example.DemoCommand - pet.name = Анфиса
22:28:24.133 [main] INFO  com.example.DemoCommand - pet.name = bagsi
22:28:24.133 [main] INFO  com.example.DemoCommand - addnig a pet ...
22:28:24.812 [main] ERROR com.example.DemoCommand - error = <ApiError><code>500</code><message>There was an error processing your request. It has been logged (ID: 1249cfb900bb6d02)</message></ApiError>
22:28:24.812 [main] INFO  com.example.DemoCommand - done ...

BUILD SUCCESSFUL in 6s
7 actionable tasks: 3 executed, 4 up-to-date

```
