package com.example.galaxyonejava.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmEntity {
    @SerializedName("page")
    public int page;
    @SerializedName("results")
    public List<Result> results;
}


class Result {
    @SerializedName("overview")
    public String overview;
    @SerializedName("poster_path")
    public String posterPath;

}