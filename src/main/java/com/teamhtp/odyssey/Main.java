package com.teamhtp.odyssey;

import com.teamhtp.odyssey.http.Router;

public class Main {

    public static final String GOOGLE_MAPS_API_KEY = System.getenv("GOOGLE_MAPS_API_KEY");

    public static void main(String[] args) {
        Router.init();
    }

}
