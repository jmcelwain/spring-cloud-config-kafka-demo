package com.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer


@EnableConfigServer
@SpringBootApplication
class DemoServerApplication {

}

fun main(args: Array<String>) {
    runApplication<DemoServerApplication>(*args)
}
