package com.demo.stream

import com.demo.config.StreamConfig
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
@EnableBinding(Sink::class)
class KafkaMessageSink(@Autowired val config: StreamConfig) {
    private val logger = LoggerFactory.getLogger(KafkaMessageSink::class.java)

    @PostConstruct
    fun postConstruct() {
        logger.info("process events: {}", config.processEvents)
    }

    @StreamListener(Sink.INPUT)
    fun receive(message: String) {
        if (config.processEvents) {
            logger.info("{}", message)
        } else {
            logger.info("ignoring message")
        }
    }
}

