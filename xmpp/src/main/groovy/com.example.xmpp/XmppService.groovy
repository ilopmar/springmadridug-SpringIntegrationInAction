package com.example.xmpp


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.xmpp.XmppHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class XmppService {

    @Value('${demo.xmpp.friend}')
    String friend

    @Autowired
    DirectChannel sendXmppMessagesChannel

    void sendMessage(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg)
            .setHeader(XmppHeaders.TO, friend)
            .build()

        sendXmppMessagesChannel.send(message)
    }

    void chatMessageReceived(String msg) {
        println  "<< Received: ${msg}"
    }

    XmppDemoCommand parseCommand(String command) {
        def cmds = command.tokenize(' ')

        if (cmds[0] == "command") {
            if (cmds.size() <= 2) {
                return new HelpCommand()
            }

            def params = cmds[2..-1]
            if (cmds[1] == "weather") {
                return new WeatherCommand(params.join(" "))
            } else if (cmds[1] == "stock") {
                return new StockCommand(params)
            }
        }

        return new HelpCommand()
    }

    String executeCommand(XmppDemoCommand command) {
        return command.execute()
    }
}
