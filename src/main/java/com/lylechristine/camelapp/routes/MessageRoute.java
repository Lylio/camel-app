package com.lylechristine.camelapp.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:messageRoute")
                .log("Message route, OH YES!")
                .setBody().constant("Some Message!!!");

        from("direct:sendMessage")
                .log("SEND message route!")
                .log("Headers: ${headers}")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    exchange.getMessage().setBody("Message is sent!\nMessage body: " + body);
                });
    }
}
