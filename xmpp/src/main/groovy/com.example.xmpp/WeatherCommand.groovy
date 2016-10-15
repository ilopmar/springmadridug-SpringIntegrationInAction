package com.example.xmpp

import groovy.json.JsonSlurper
import groovy.transform.TupleConstructor

@TupleConstructor
class WeatherCommand implements XmppDemoCommand {

    private static final String API_KEY = "YOUR_API_KEY"

    String city

    @Override
    String execute() {
        URL url = "http://api.openweathermap.org/data/2.5/weather?apiKey=${API_KEY}&units=metric&q=${this.city.replaceAll(' ', '+')}".toURL()
        def content = url.getText("UTF-8")
        def response = new JsonSlurper().parseText(content)

        String weather = response.weather.collect { it.description }.join(", ")
        String country = response.sys.country
        String temp = response.main.temp
        String city = response.name

        return "El tiempo en ${city} (${country}) es: \n Tiempo: ${weather} \n Temp: ${temp} ºC"
    }
}
