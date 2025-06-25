package com.sb.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}

data class HelloResponse(val message: String)

@RestController
class DemoController {
    val words = listOf("Code","Space","Chaos","Spring","Kotlin","Nonsense")

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun sayHello2(): HelloResponse {
        return HelloResponse("Hello from ${words.random()} und sweet grass")
    }
}
