package com.lylechristine.camelapp.routes;

import org.apache.camel.builder.RouteBuilder;

public class FileMoveRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/data?noop=true").to("file:target/messages/others")
                .routeId("file-move")
                .log("MOVING FILES!")
                .log(">>> %{body}");

    }
}
