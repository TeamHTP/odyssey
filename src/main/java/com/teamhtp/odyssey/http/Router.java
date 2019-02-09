package com.teamhtp.odyssey.http;

import com.teamhtp.odyssey.logic.Attractions;
import com.teamhtp.odyssey.logic.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class Router {

    public static void init() {
        port(80);
        Router.CORS();
        Logger log = LoggerFactory.getLogger(Router.class);
        path("/api", () -> {
            before("/*", (q, a) -> log.info("Received api call"));
            path("/attractions", () -> {
                get("/", Attractions.getAtLocation);
                get("/details/", Attractions.getPlaceDetails);
            });
            path("/route", () -> {
                get("/", Route.getRoute);
            });
        });
    }

    public static void CORS() {
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.type("application/json");
        });
    }

}
