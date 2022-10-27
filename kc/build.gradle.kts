plugins {
  id("org.jetbrains.kotlin.jvm") version "1.6.10"
  id("org.jetbrains.kotlin.kapt") version "1.6.10"
  id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
  id("com.github.johnrengelman.shadow") version "7.1.2"
  id("io.micronaut.application") version "3.3.1"
  id("jacoco")
  id("org.sonarqube") version "3.3"
  id("org.openapi.generator") version "6.2.0"
  id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

version = "0.1"
group = "com.example"

val micronautVersion: String by project
val targetJvmVersion: String by project
val kotlinVersion: String by project

repositories {
  mavenCentral()
}

micronaut {
  version(micronautVersion)
  testRuntime("junit5")
  processing {
    incremental(true)
    annotations("com.example.*")
  }
}

// kotlin {
//  jvmToolchain {
//    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(targetJvmVersion))
//  }
// }

dependencies {
  implementation(kotlin("reflect"))
  kapt("io.micronaut:micronaut-http-validation")
  kapt("io.micronaut.openapi:micronaut-openapi")
  kapt("info.picocli:picocli-codegen")

  implementation("info.picocli:picocli")

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
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

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

jacoco {
  toolVersion = "0.8.7"
}

java {
  sourceCompatibility = JavaVersion.toVersion(targetJvmVersion)
}

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = targetJvmVersion
    }
  }
  compileTestKotlin {
    kotlinOptions {
      jvmTarget = targetJvmVersion
    }
  }
}
graalvmNative.toolchainDetection.set(false)

openApiGenerate {
  // https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin#openapigenerate
  // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators.md
  // https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/kotlin.md
  val openApiGroup = "com.example.petstore"
  generatorName.set("kotlin")
  inputSpec.set("$rootDir/spec/openapi/petstore3.yaml")
  apiPackage.set("$openApiGroup.api")
  modelPackage.set("$openApiGroup.model")
  validateSpec.set(true)
  // This is here to disable generation of api and supporting files, setting only models results in only model generation.
  globalProperties.set(
    mapOf(
      "models" to ""
    )
  )
  configOptions.set(
    mapOf(
      "dateLibrary" to "java8",
      "enumPropertyNaming" to "UPPERCASE",
      "collectionType" to "list",
      "serializationLibrary" to "jackson"
    )
  )
}

sourceSets.main {
  java.srcDir("$buildDir/generate-resources/main/src/main/kotlin")
}

ktlint {
  filter {
    exclude { entry ->
      logger.info("entry.file = ${entry.file}")
      entry.file.toString().contains("generate")
    }
  }
}

tasks {
  compileKotlin {
    dependsOn(openApiGenerate)
  }
  compileTestKotlin {
    dependsOn(openApiGenerate)
  }
}
