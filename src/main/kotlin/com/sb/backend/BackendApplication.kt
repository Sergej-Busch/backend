package com.sb.backend

import kotlinx.coroutines.delay
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

    @GetMapping("/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun sayHello(): HelloResponse {
        delay(1000)
        return HelloResponse("Hello from coroutine")
    }
}
