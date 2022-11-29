package com.example.galaxyonejava.domain.usecase;



import com.example.galaxyonejava.data.entity.FilmEntity;

import io.reactivex.Observable;

public interface GetListFilmUsecase {
    Observable<FilmEntity> excute();
}


