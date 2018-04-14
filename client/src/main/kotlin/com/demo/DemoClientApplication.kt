package com.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.anyExchange
import org.springframework.security.authorization.AuthenticatedReactiveAuthorizationManager.authenticated
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain



@SpringBootApplication(scanBasePackages = ["com.demo", "com.demo.stream", "com.demo.config"])
class DemoClientApplication {

}

fun main(args: Array<String>) {
    runApplication<DemoClientApplication>(*args)
}
