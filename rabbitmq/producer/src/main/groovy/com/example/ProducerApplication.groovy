package com.example

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ImportResource
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@EnableIntegration
@ImportResource("integration.xml")
class ProducerApplication {

    static void main(String[] args) {
        SpringApplication.run ProducerApplication, args
    }

    @Bean
    CommandLineRunner runner(ReverseGateway reverseGateway, UppercaseGateway uppercaseGateway) {
        { args ->
            reverseGateway.send([name: 'Iván', lastName: 'López', age: 36])
            uppercaseGateway.send([name: 'Iván', lastName: 'López', age: 36])
        }
    }

}
