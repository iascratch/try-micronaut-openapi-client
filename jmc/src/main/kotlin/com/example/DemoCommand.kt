package com.example

import com.example.petstore.api.PetApi
import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Inject
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import org.slf4j.LoggerFactory

@Command(
  name = "demo",
  description = ["..."],
  mixinStandardHelpOptions = true
)
class DemoCommand : Runnable {
  private val logger = LoggerFactory.getLogger(javaClass)


  @Inject
  lateinit var api: PetApi

  @Option(names = ["-v", "--verbose"], description = ["..."])
  private var verbose: Boolean = false

  override fun run() {
    logger.info("entry ...")
    // business logic here
//    if (verbose) {
//      println("Hi!")
//    }

    api.findPetsByStatus("sold").block().forEach {
      logger.info("pet.name = {}", it.name)
    }

  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      PicocliRunner.run(DemoCommand::class.java, *args)
    }
  }
}
