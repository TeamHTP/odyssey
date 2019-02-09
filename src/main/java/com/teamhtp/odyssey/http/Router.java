package com.teamhtp.odyssey.http;

import com.teamhtp.odyssey.logic.Attractions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class Router {

    public static void init() {
        Logger log = LoggerFactory.getLogger(Router.class);
        path("/api", () -> {
            before("/*", (q, a) -> log.info("Received api call"));
            path("/attractions", () -> {
                get("/", Attractions.getAtLocation);
            });
        });
    }

}
