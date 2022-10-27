package com.example

import com.example.petstore.api.PetApi
import com.example.petstore.model.Pet
import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import picocli.CommandLine.Command

@Command(
  name = "demo",
  description = ["..."],
  mixinStandardHelpOptions = true
)
class DemoCommand : Runnable {
  private val logger = LoggerFactory.getLogger(javaClass)

  @Inject
  lateinit var api: PetApi

  override fun run() {
    logger.info("entry ...")
    logger.info("getting sold pets ...")
    api.findPetsByStatus("sold").block().forEach {
      logger.info("pet.name = {}", it.name)
    }
    try {
      logger.info("addnig a pet ...")
      val addedPet = api.addPet(Pet("iadaingu", listOf())).block()
      logger.info("added pet {}", addedPet)
    } catch (error: Exception) {
      logger.error("error = {}", error.message)
    }
    logger.info("done ...")
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      PicocliRunner.run(DemoCommand::class.java, *args)
    }
  }
}
