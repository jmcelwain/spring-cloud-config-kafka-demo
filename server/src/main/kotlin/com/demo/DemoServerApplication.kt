package com.demo

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import javax.annotation.PostConstruct


@EnableConfigServer
@SpringBootApplication
class DemoServerApplication(@Autowired val jdbc: JdbcTemplate, @Autowired val env: Environment) {
    val logger = LoggerFactory.getLogger(this::class.java)

    @PostConstruct
    fun postConstruct() {
        if (env.activeProfiles.contains("test")) return

        logger.info("Create property if not exists")
        val i = jdbc.update(this::class.java.getResource("/properties.sql").readText())
        logger.info("{}", i)
    }
}

fun main(args: Array<String>) {
    runApplication<DemoServerApplication>(*args)
}
