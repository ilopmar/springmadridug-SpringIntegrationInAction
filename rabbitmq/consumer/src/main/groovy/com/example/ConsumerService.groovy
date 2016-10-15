package com.example

import org.springframework.stereotype.Service

@Service
class ConsumerService {

    void reverseMessage(Map msg) {
        println "=== Reverse Message ==="
        msg.each { k,v ->
            println "$k = ${v.toString().reverse()}"
        }
    }

    void uppercaseMessage(Map msg) {
        println "=== Uppercase Message ==="
        msg.each { k,v ->
            println "$k = ${v.toString().toUpperCase()}"
        }
    }
}
