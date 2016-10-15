package com.example.common

import groovy.json.JsonSlurper

class JsonDeserializer {
    Map fromJson(String payload) {
        return new JsonSlurper().parse(payload.bytes)
    }
}
