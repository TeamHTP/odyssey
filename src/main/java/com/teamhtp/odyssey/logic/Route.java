package com.teamhtp.odyssey.logic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.teamhtp.odyssey.Main;

public class Route {

    public static spark.Route getRoute = (q, a) -> {
        String origin = q.queryParams("origin");
        String waypoints = q.queryParams("waypoints");
        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://maps.googleapis.com/maps/api/directions/json")
                .header("accept", "application/json")
                .queryString("key", Main.GOOGLE_MAPS_API_KEY)
                .queryString("origin", origin)
                .queryString("waypoints", waypoints)
                .queryString("destination", origin)
                .asJson();
        return jsonResponse.getBody();
    };

}
