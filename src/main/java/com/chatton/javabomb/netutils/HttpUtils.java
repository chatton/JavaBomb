package com.chatton.javabomb.netutils;


import com.google.gson.Gson;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class HttpUtils {
    private HttpUtils() {
    }

    public static <T> T GET(final String url, final Class<T> clazz) {
        return new Gson().fromJson(ClientBuilder
                .newClient()
                .target(url)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class), clazz);
    }
}
