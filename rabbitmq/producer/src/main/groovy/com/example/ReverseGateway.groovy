package com.example

import org.springframework.messaging.handler.annotation.Payload

interface ReverseGateway {

    void send(@Payload Map message)
}