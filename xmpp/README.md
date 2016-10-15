# XMPP Integration #

Example of how to integrate a Spring Boot application with a XMPP server using Spring Integration.

Before start the application you need to:

- Create an `application.yml` file with your XMPP credentials. You can use the included `application.yml.sample` as a template:

```
demo:
  xmpp:
    user: YOUR-BOT-GMAIL-ACCOUNT@gmail.com
    password: YOUR-PASSWORD
    host: talk.google.com
    port: 5222
    friend: YOUR-PERSONAL-ACCOUNT@gmail.com
```

Please note that both users must be "friends".

- Set you own openweather api key in `WeatherCommand.groovy`:

```groovy
private static final String API_KEY = "YOUR_API_KEY"
```
