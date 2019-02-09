package com.teamhtp.odyssey.logic;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.teamhtp.odyssey.Main;
import com.teamhtp.odyssey.SessionAttribute;
import spark.Route;

public class Attractions {

    public static Route getAtLocation = (q, a) -> {
        long rad = Long.getLong(q.queryParams("rad"));
        long lat = Long.getLong(q.queryParams("lat"));
        long lng = Long.getLong(q.queryParams("lng"));
        String sessionId = q.session().attribute(SessionAttribute.USER_SESSION_ID);
        HttpResponse<String> jsonResponse = Unirest.get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json")
                .header("accept", "application/json")
                .queryString("key", Main.GOOGLE_MAPS_API_KEY)
                .queryString("inputtype", "textquery")
                .queryString("locationbias", "circle:" + rad + "@" + lat + "," + lng)
                .asString();
        return new Gson().toJson(jsonResponse.getBody());
    };

}
