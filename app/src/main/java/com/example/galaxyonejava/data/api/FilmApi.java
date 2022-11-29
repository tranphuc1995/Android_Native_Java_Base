package com.example.galaxyonejava.data.api;



import com.example.galaxyonejava.data.entity.FilmEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FilmApi {
    @GET("3/discover/movie?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3")
        // suspend fun getListFilm(): Response<FilmEntity>
    Observable<FilmEntity> getListFilm();
}
