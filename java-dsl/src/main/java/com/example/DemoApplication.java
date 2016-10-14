package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.endpoint.MethodInvokingMessageSource;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@IntegrationComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public MessageSource<?> integerMessageSource() {
        MethodInvokingMessageSource source = new MethodInvokingMessageSource();
        source.setObject(new AtomicInteger());
        source.setMethodName("getAndIncrement");
        return source;
    }

    @Bean
    DirectChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow myFlow(DemoService demoService) {
        return IntegrationFlows
            .from(this.integerMessageSource(), c -> c.poller(Pollers.fixedDelay(1000)))
            .channel(this.inputChannel())
            .filter(demoService::integerFilter)
            .transform(demoService::convertToString)
            .channel(this.outputChannel())
            .get();
    }

    @Bean
    DirectChannel outputChannel() {
        return new DirectChannel();
    }

    @ServiceActivator(inputChannel = "outputChannel")
    public void consumir(String s) {
        System.out.println("El número es: " + s);
    }

}
