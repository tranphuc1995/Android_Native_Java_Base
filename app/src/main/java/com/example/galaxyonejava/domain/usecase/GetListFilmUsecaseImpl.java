package com.example.galaxyonejava.domain.usecase;



import com.example.galaxyonejava.data.entity.FilmEntity;
import com.example.galaxyonejava.domain.repository.FilmRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetListFilmUsecaseImpl implements GetListFilmUsecase {

    private FilmRepository filmRepository;

    @Inject
    public GetListFilmUsecaseImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Observable<FilmEntity> excute() {

        return filmRepository.getListFilm();
    }
}
