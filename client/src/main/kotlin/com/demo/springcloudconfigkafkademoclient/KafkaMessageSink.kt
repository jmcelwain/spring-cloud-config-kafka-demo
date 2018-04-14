package com.demo.springcloudconfigkafkademoclient

import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
@EnableBinding(Sink::class)
open class KafkaMessageSink {
    private val logger = LoggerFactory.getLogger(KafkaMessageSink::class.java)

    @StreamListener(Sink.INPUT)
    fun receive(message: String) {
        logger.info("{}", message)
    }
}

