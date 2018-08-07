package com.example.jmsactivemqfailover;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class JmsStarter implements ApplicationRunner {
    private final JmsListenerEndpointRegistry jmsRegistry;

    public JmsStarter(JmsListenerEndpointRegistry jmsRegistry) {
        this.jmsRegistry = jmsRegistry;
    }

    @Override
    public void run(ApplicationArguments args) {
        for (MessageListenerContainer listenerContainer : jmsRegistry.getListenerContainers()) {
            listenerContainer.start();
        }
    }
}
