package com.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["com.demo", "com.demo.stream", "com.demo.config"])
class DemoClientApplication {

}

fun main(args: Array<String>) {
    runApplication<DemoClientApplication>(*args)
}
