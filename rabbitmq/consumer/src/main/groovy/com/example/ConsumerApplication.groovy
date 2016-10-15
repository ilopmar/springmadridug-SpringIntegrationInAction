package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@EnableIntegration
@ImportResource("integration.xml")
class ConsumerApplication {

    static void main(String[] args) {
        SpringApplication.run ConsumerApplication, args
    }

}
