package com.teamhtp.odyssey.logic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.teamhtp.odyssey.Main;
import com.teamhtp.odyssey.SessionAttribute;
import spark.Route;

public class Attractions {

    public static Route getAtLocation = (q, a) -> {
        String rad = q.queryParams("rad");
        String lat = q.queryParams("lat");
        String lng = q.queryParams("lng");
        String sessionId = q.session().attribute(SessionAttribute.USER_SESSION_ID);
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
                .header("accept", "application/json")
                .queryString("key", Main.GOOGLE_MAPS_API_KEY)
                .queryString("radius", rad)
                .queryString("location", lat + "," + lng)
                .queryString("keyword", "attractions")
                .asJson();
        return jsonResponse.getBody();
    };

    public static Route getPlaceDetails = (q, a) -> {
        String placeId = q.queryParams("placeId");
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://maps.googleapis.com/maps/api/place/details/json")
                .header("accept", "application/json")
                .queryString("key", Main.GOOGLE_MAPS_API_KEY)
                .queryString("placeid", placeId)
                .asJson();
        return jsonResponse.getBody();
    };

}
