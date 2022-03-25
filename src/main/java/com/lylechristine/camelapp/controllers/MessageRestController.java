package com.lylechristine.camelapp.controllers;

import org.apache.camel.FluentProducerTemplate;
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
}
