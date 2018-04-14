package com.demo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@RefreshScope
@Configuration
class StreamConfig {
    @Value("\${events.process}")
    var processEvents: Boolean = false
}