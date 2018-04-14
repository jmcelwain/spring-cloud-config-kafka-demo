package com.demo.springcloudconfigkafkademoclient

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
@RefreshScope
@EnableBinding(Sink::class)
open class KafkaMessageSink {
    private val logger = LoggerFactory.getLogger(KafkaMessageSink::class.java)

    @Value("\${events.process}")
    var processEvents: Boolean = false

    @StreamListener(Sink.INPUT)
    fun receive(message: String) {
        if (processEvents) {
            logger.info("{}", message)
        }
    }
}

