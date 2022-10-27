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

//    logger.info("getting sold pets ...")
//    api.findPetsByStatus("sold").block().forEach {
//      logger.info("pet.name = {}", it.name)
//    }
//    try {
//      logger.info("adding a pet ...")
//      val addedPet = api.addPet(Pet("iadaingu", listOf())).block()
//      logger.info("added pet {}", addedPet)
//    } catch (error: Exception) {
//      logger.error("error = {}", error.message)
//    }
    logger.info("done ...")
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      PicocliRunner.run(DemoCommand::class.java, *args)
    }
  }
}
