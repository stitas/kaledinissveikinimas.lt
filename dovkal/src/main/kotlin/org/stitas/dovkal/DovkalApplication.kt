package org.stitas.dovkal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class DovkalApplication

fun main(args: Array<String>) {
	runApplication<DovkalApplication>(*args)
}
