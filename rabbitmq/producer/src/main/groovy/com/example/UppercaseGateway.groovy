package com.example

import org.springframework.messaging.handler.annotation.Payload

interface UppercaseGateway {

    void send(@Payload Map message)
}