package com.example.galaxyonejava.data;


import com.example.galaxyonejava.data.api.FilmApi;
import com.example.galaxyonejava.data.entity.FilmEntity;
import com.example.galaxyonejava.domain.repository.FilmRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FilmRepositoryImpl implements FilmRepository {

    private FilmApi filmApi;

    @Inject
    public FilmRepositoryImpl(FilmApi filmApi) {
        this.filmApi = filmApi;
    }

    @Override
    public Observable<FilmEntity> getListFilm() {
        return filmApi.getListFilm();
    }
}
