package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.configuration;

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
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin123");
        return factory;
    }

    // Exchanges
    @Bean
    public DirectExchange pratosRestauranteExchange() {
        return ExchangeBuilder.directExchange("pratos-restaurante-request-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange pratosRestauranteResponseErroExchange() {
        return ExchangeBuilder.directExchange("pratos-restaurante-response-erro-exchange")
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange pratosRestauranteResponseSucessoExchange() {
        return ExchangeBuilder.directExchange("pratos-restaurante-response-sucesso-exchange")
                .durable(true)
                .build();
    }

    // Queues
    @Bean
    public Queue pratosRestauranteRequestQueue() {
        return new Queue("pratos-restaurante-request-queue", true);
    }

    @Bean
    public Queue pratosRestauranteResponseErroQueue() {
        return new Queue("pratos-restaurante-response-erro-queue", true);
    }

    @Bean
    public Queue pratosRestauranteResponseSucessoQueue() {
        return new Queue("pratos-restaurante-response-sucesso-queue", true);
    }

    // Bindings
    @Bean
    public Binding pratosRestauranteRequestBinding(DirectExchange pratosRestauranteExchange, Queue pratosRestauranteRequestQueue) {
        return BindingBuilder.bind(pratosRestauranteRequestQueue)
                .to(pratosRestauranteExchange)
                .with("pratos-restaurante-request-rout-key");
    }

    @Bean
    public Binding pratosRestauranteResponseErroBinding(DirectExchange pratosRestauranteResponseErroExchange, Queue pratosRestauranteResponseErroQueue) {
        return BindingBuilder.bind(pratosRestauranteResponseErroQueue)
                .to(pratosRestauranteResponseErroExchange)
                .with("pratos-restaurante-response-erro-rout-key");
    }

    @Bean
    public Binding pratosRestauranteResponseSucessoBinding(DirectExchange pratosRestauranteResponseSucessoExchange, Queue pratosRestauranteResponseSucessoQueue) {
        return BindingBuilder.bind(pratosRestauranteResponseSucessoQueue)
                .to(pratosRestauranteResponseSucessoExchange)
                .with("pratos-restaurante-response-sucesso-rout-key");
    }


}

