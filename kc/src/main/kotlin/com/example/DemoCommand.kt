package com.example

// import com.example.petstore.api.PetApi
import com.example.petstore.model.Pet
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.micronaut.configuration.picocli.PicocliRunner
import org.slf4j.LoggerFactory
import picocli.CommandLine.Command

@Command(
  name = "demo",
  description = ["..."],
  mixinStandardHelpOptions = true
)
class DemoCommand : Runnable {
  private val logger = LoggerFactory.getLogger(javaClass)

//  @Inject
//  lateinit var api: PetApi

  override fun run() {
    logger.info("entry ...")
    val somePet = Pet("iadaingu", listOf())
    val mapper = jacksonObjectMapper()
    logger.info("somePet = {}", mapper.writeValueAsString(somePet))
    logger.info("done ...")
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      PicocliRunner.run(DemoCommand::class.java, *args)
    }
  }
}
