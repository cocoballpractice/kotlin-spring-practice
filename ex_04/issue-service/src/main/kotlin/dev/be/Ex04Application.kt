package dev.be

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class Ex04Application

fun main(args: Array<String>) {
    runApplication<Ex04Application>(*args)
}
