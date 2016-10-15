package com.example

import com.example.xmpp.XmppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@ImportResource("integration.xml")
class DemoApplication {

    static void main(String[] args) {
        SpringApplication.run DemoApplication, args
    }

    @RestController
    class XmppController {

        @Autowired
        XmppService xmppService

        @RequestMapping(method = RequestMethod.GET, path = "/xmpp")
        void sendMsg(Optional<String> msg) {
            xmppService.sendMessage(msg.orElse("Hola SpringMadrid UG"))
        }
    }
}

