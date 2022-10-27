package com.example

// import com.example.petstore.api.PetApi
import com.example.petstore.model.Pet
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.micronaut.configuration.picocli.PicocliRunner
import org.slf4j.LoggerFactory
import picocli.CommandLine.Command
import java.time.Period

val Pet.agePeriod: Period?
  get() = if (age != null) Period.parse(age) else null

@Command(
  name = "demo",
  description = ["..."],
  mixinStandardHelpOptions = true
)
class DemoCommand : Runnable {
  private val logger = LoggerFactory.getLogger(javaClass)

  override fun run() {
    logger.info("entry ...")
    val somePet = Pet("iadaingu", listOf(), age = "P1Y2M3D")
    val mapper = jacksonObjectMapper()
    logger.info("somePet = {}, somePet.agePeriod = {}", mapper.writeValueAsString(somePet), somePet.agePeriod)
    logger.info("done ...")
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      PicocliRunner.run(DemoCommand::class.java, *args)
    }
  }
}
