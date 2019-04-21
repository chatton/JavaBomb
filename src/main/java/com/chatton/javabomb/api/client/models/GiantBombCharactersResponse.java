package com.chatton.javabomb.api.client.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GiantBombCharactersResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("limit")
    @Expose
    private Integer limit;

    @SerializedName("offset")
    @Expose
    private Integer offset;

    @SerializedName("number_of_page_results")
    @Expose
    private Integer numberOfPageResults;

    @SerializedName("number_of_total_results")
    @Expose
    private Integer numberOfTotalResults;

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    @SerializedName("results")
    @Expose
    private List<Object> results = new ArrayList<>();

    @SerializedName("version")
    @Expose
    private String version;
}