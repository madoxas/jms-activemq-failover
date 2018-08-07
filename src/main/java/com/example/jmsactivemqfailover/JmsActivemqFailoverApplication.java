package com.example.jmsactivemqfailover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJms
public class JmsActivemqFailoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmsActivemqFailoverApplication.class, args);
    }

    @Component
    public static class JmsReceiver {
        @JmsListener(destination = "inbox")
        public void receive(Message message) {
            System.out.println("Received <" + message + ">");
        }
    }

    @RestController
    public static class HelloWorldController {
        @GetMapping("/")
        public String helloWorld() {
            return "Hello world";
        }
    }
}
