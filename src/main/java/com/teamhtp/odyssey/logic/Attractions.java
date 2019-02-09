package com.teamhtp.odyssey.logic;

import com.google.gson.Gson;
import spark.Route;

public class Attractions {

    public static Route getAtLocation = (q, a) -> {
        return new Gson().toJson(q.params());
    };

}
