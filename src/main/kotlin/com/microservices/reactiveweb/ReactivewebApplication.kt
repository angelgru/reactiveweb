package com.microservices.reactiveweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactivewebApplication

fun main(args: Array<String>) {
    runApplication<ReactivewebApplication>(*args)
}

