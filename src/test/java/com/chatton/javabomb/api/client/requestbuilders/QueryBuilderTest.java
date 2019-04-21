package com.chatton.javabomb.api.client.requestbuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class QueryBuilderTest {

    private final static String baseUrl = "http://my.base.url/";

    @Test
    public void testQueryBuilderAddField(){
        final String expected = baseUrl + "?field_one=123&field_two=456&field_three=789";
        final String actual = new QueryBuilder(baseUrl, new ArrayList<>())
                .addField("field_one", "123")
                .addField("field_two", "456")
                .addField("field_three", "789")
                .build();

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testQueryBuilderIgnoresNulls(){
        final String expected = baseUrl + "?field_three=789";
        final String actual = new QueryBuilder(baseUrl, new ArrayList<>())
                .addField("field_one", null)
                .addField("field_two", null)
                .addField("field_three", "789")
                .build();

        assertThat(actual, equalTo(expected));
    }

}