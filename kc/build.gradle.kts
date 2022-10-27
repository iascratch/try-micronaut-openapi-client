plugins {
  id("org.jetbrains.kotlin.jvm") version "1.6.21"
  id("org.jetbrains.kotlin.kapt") version "1.6.21"
  id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
  id("com.github.johnrengelman.shadow") version "7.1.2"
  id("io.micronaut.application") version "3.6.2"
  id("org.openapi.generator") version "6.2.0"
//  id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

version = "0.1"
group = "com.example"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
  mavenCentral()
}

dependencies {
  kapt("info.picocli:picocli-codegen")
  implementation("info.picocli:picocli")

  kapt("io.micronaut:micronaut-http-validation")
  kapt("io.micronaut.openapi:micronaut-openapi")
  implementation("io.micronaut.picocli:micronaut-picocli")
  implementation("io.micronaut:micronaut-http-client")
  implementation("io.micronaut:micronaut-jackson-databind")
  implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
  implementation("jakarta.annotation:jakarta.annotation-api")
  implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
  runtimeOnly("ch.qos.logback:logback-classic")
  implementation("io.micronaut:micronaut-validation")
  implementation("io.swagger.core.v3:swagger-annotations")
  testImplementation("io.micronaut:micronaut-http-client")

  annotationProcessor("io.micronaut:micronaut-http-validation")
  annotationProcessor("io.micronaut.security:micronaut-security-annotations")
  implementation("io.micronaut:micronaut-http-client")
  implementation("io.micronaut:micronaut-runtime")
  implementation("io.micronaut.security:micronaut-security")
  implementation("io.micronaut.security:micronaut-security-oauth2")
  implementation("io.micronaut.reactor:micronaut-reactor")
  compileOnly("com.google.code.findbugs:jsr305")
  runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")


}

application {
  mainClass.set("com.example.DemoCommand")
}
java {
  sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = "17"
    }
  }
  compileTestKotlin {
    kotlinOptions {
      jvmTarget = "17"
    }
  }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("com.example.*")
  }
}

sourceSets.main {
//  kotlin.srcDir("$buildDir/generate-resources/main/src/main/kotlin")
  java.srcDir("$buildDir/generate-resources/main/src/main/java")
}

openApiGenerate {
  // https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin#openapigenerate
  // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators.md
  // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/jaxrs-spec.md
  val openApiGroup = "com.example.petstore"
  generatorName.set("kotlin")

//  val openApiGroup = "no.vy.personnel.sertifikatregister"
//  generatorName.set("kotlin")
  inputSpec.set("$rootDir/spec/openapi/petstore3.yaml")
  apiPackage.set("$openApiGroup.api")
  modelPackage.set("$openApiGroup.model")
// //  invokerPackage.set("$openApiGroup.invoker")
//  validateSpec.set(true)
// //  modelFilesConstrainedTo.set(listOf("CompetenceCodeDTO", "CompetenceTargetGroup", "CompetenceType"))
//  configOptions.put("enumPropertyNaming", "UPPERCASE")
//
//  globalProperties.apply {
//    put("modelDocs", "false")
//  }
//
//  configOptions.set(
//    mapOf(
//      "dateLibrary" to "string",
//      "enumPropertyNaming" to "UPPERCASE",
//      "collectionType" to "list",
//    )
//  )

//  sourceSets.main {
//    java.srcDirs("$buildDir/generated/src/main/kotlin")
//  }
}

// ktlint {
//  filter {
//    exclude("**/generate-resources/**")
// //    exclude("**/generated/**")
//  }
// }

// configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
//  filter {
//    exclude("**/generate-resources/**")
//  }
// }

// ktlint {
//  filter {
//    exclude { entry ->
//      logger.info("entry.file = ${entry.file}")
//      entry.file.toString().contains("generate")
//    }
//  }
// }

// compileKotlin.dependsOn(tasks.openApiGenerate, tasks.ktlintCheck, tasks.detekt)

tasks {
  compileKotlin {
    dependsOn(openApiGenerate)
  }
  compileTestKotlin {
    dependsOn(openApiGenerate)
  }
}
