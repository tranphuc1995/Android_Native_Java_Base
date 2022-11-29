package com.example.galaxyonejava.domain.repository;


import com.example.galaxyonejava.data.entity.FilmEntity;

import io.reactivex.Observable;

public interface FilmRepository {
    Observable<FilmEntity> getListFilm();
}
