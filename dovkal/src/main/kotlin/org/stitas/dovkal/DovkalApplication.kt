package org.stitas.dovkal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DovkalApplication

fun main(args: Array<String>) {
	runApplication<DovkalApplication>(*args)
}
