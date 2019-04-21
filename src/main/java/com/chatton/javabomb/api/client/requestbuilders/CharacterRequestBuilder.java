package com.chatton.javabomb.api.client.requestbuilders;

import com.chatton.javabomb.api.client.models.GiantBombCharactersResponse;
import com.chatton.javabomb.netutils.HttpUtils;

public class CharacterRequestBuilder {

    private final String apiKey;
    private final String baseUrl;
    private Integer limit;
    private Integer offset;
    private String fields;

    public CharacterRequestBuilder(final String apiKey, final String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.limit = 100;
    }

    public CharacterRequestBuilder fieldList(final String[] fields) {
        this.fields = String.join(",", fields);
        return this;
    }

    public CharacterRequestBuilder limit(final int limit) {
        this.limit = limit;
        return this;
    }

    public CharacterRequestBuilder offset(final int offset) {
        this.offset = offset;
        return this;
    }

    public GiantBombCharactersResponse get(){
        final String query = new QueryBuilder(baseUrl)
                .addField("api_key", apiKey)
                .addField("field_list", fields)
                .addField("limit", limit)
                .addField("offset", offset)
                .build();

        return HttpUtils.GET(query, GiantBombCharactersResponse.class);
    }
}
