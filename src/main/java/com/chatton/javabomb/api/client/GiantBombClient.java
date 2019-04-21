package com.chatton.javabomb.api.client;

import com.chatton.javabomb.api.client.requestbuilders.CharacterRequestBuilder;
import java.util.Objects;

// https://www.giantbomb.com/api/documentation
public class GiantBombClient {

    private final String apiKey;
    private final String baseUrl;

    public GiantBombClient(final String apiKey) {
        this(apiKey, "https://www.giantbomb.com/api/");
    }

    public GiantBombClient(final String apiKey, final String baseUrl) {
        Objects.requireNonNull(apiKey, baseUrl);
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public CharacterRequestBuilder characters() {
        return new CharacterRequestBuilder(apiKey, baseUrl + "characters/");
    }

}
