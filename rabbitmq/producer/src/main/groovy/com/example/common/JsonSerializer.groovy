package com.example.common

import groovy.json.JsonOutput

class JsonSerializer {
    String toJson(Map payload) {
        return JsonOutput.toJson(payload)
    }
}
