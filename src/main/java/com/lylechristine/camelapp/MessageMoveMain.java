package com.lylechristine.camelapp;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MessageMoveMain {

    public static void main(String args[]) throws Exception {
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
