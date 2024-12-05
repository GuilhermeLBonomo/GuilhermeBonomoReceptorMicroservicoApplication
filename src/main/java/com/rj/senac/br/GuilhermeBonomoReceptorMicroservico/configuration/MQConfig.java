package com.rj.senac.br.GuilhermeBonomoEmissorMicroservico.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("rabbitmq");
        factory.setUsername("admin");
        factory.setPassword("admin123");
        return factory;
    }

    // Exchanges
    @Bean
    public DirectExchange contaInstagramRequestExchange() {
        return ExchangeBuilder.directExchange("conta-instagram-request-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange contaInstagramResponseErroExchange() {
        return ExchangeBuilder.directExchange("conta-instagram-response-erro-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange contaInstagramResponseSucessoExchange() {
        return ExchangeBuilder.directExchange("conta-instagram-response-sucesso-exchange")
                .durable(true)
                .build();
    }

    // Exchanges for Account Removal
    @Bean
    public DirectExchange contaInstagramRemovalRequestExchange() {
        return ExchangeBuilder.directExchange("conta-instagram-removal-request-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange contaInstagramRemovalResponseErroExchange() {
        return ExchangeBuilder.directExchange("conta-instagram-removal-response-erro-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange contaInstagramRemovalResponseSucessoExchange() {
        return ExchangeBuilder.directExchange("conta-instagram-removal-response-sucesso-exchange")
                .durable(true)
                .build();
    }

    // Queues
    @Bean
    public Queue contaInstagramRequestQueue() {
        return new Queue("conta-instagram-request-queue", true);
    }

    @Bean
    public Queue contaInstagramResponseErroQueue() {
        return new Queue("conta-instagram-response-erro-queue", true);
    }

    @Bean
    public Queue contaInstagramResponseSucessoQueue() {
        return new Queue("conta-instagram-response-sucesso-queue", true);
    }

    // Queues for Account Removal
    @Bean
    public Queue contaInstagramRemovalRequestQueue() {
        return new Queue("conta-instagram-removal-request-queue", true);
    }

    @Bean
    public Queue contaInstagramRemovalResponseErroQueue() {
        return new Queue("conta-instagram-removal-response-erro-queue", true);
    }

    @Bean
    public Queue contaInstagramRemovalResponseSucessoQueue() {
        return new Queue("conta-instagram-removal-response-sucesso-queue", true);
    }

    // Bindings
    @Bean
    public Binding contaInstagramRequestBinding(DirectExchange contaInstagramRequestExchange, Queue contaInstagramRequestQueue) {
        return BindingBuilder.bind(contaInstagramRequestQueue)
                .to(contaInstagramRequestExchange)
                .with("conta-instagram-request-rout-key");
    }

    @Bean
    public Binding contaInstagramResponseErroBinding(DirectExchange contaInstagramResponseErroExchange, Queue contaInstagramResponseErroQueue) {
        return BindingBuilder.bind(contaInstagramResponseErroQueue)
                .to(contaInstagramResponseErroExchange)
                .with("conta-instagram-response-erro-rout-key");
    }

    @Bean
    public Binding contaInstagramResponseSucessoBinding(DirectExchange contaInstagramResponseSucessoExchange, Queue contaInstagramResponseSucessoQueue) {
        return BindingBuilder.bind(contaInstagramResponseSucessoQueue)
                .to(contaInstagramResponseSucessoExchange)
                .with("conta-instagram-response-sucesso-rout-key");
    }

    // Bindings for Account Removal
    @Bean
    public Binding contaInstagramRemovalRequestBinding(DirectExchange contaInstagramRemovalRequestExchange, Queue contaInstagramRemovalRequestQueue) {
        return BindingBuilder.bind(contaInstagramRemovalRequestQueue)
                .to(contaInstagramRemovalRequestExchange)
                .with("conta-instagram-removal-request-rout-key");
    }

    @Bean
    public Binding contaInstagramRemovalResponseErroBinding(DirectExchange contaInstagramRemovalResponseErroExchange, Queue contaInstagramRemovalResponseErroQueue) {
        return BindingBuilder.bind(contaInstagramRemovalResponseErroQueue)
                .to(contaInstagramRemovalResponseErroExchange)
                .with("conta-instagram-removal-response-erro-rout-key");
    }

    @Bean
    public Binding contaInstagramRemovalResponseSucessoBinding(DirectExchange contaInstagramRemovalResponseSucessoExchange, Queue contaInstagramRemovalResponseSucessoQueue) {
        return BindingBuilder.bind(contaInstagramRemovalResponseSucessoQueue)
                .to(contaInstagramRemovalResponseSucessoExchange)
                .with("conta-instagram-removal-response-sucesso-rout-key");
    }
}
