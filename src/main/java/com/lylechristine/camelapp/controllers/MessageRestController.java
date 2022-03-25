package com.lylechristine.camelapp.controllers;

import org.apache.camel.CamelContext;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    private final FluentProducerTemplate producerTemplate;

    public MessageRestController(FluentProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @GetMapping(value = "/messages")
    public String getMessages() {
        return producerTemplate.to("direct:messageRoute").request(String.class);
    }

    @PostMapping(value = "/message")
    public String sendMessage(@RequestBody String body) {
        return producerTemplate.withBody(body).withHeader("test", "1").to("direct:sendMessage").request(String.class);
    }

    @GetMapping(value = "/filemove")
    public void fileMove() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(
                new RouteBuilder() {
                    public void configure() {
                        from("file:src/data?noop=true").to("file:target/messages/others");
                    }
                });
        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
