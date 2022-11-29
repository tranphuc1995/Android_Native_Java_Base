package com.example.galaxyonejava.presentation.di;

import com.example.galaxyonejava.domain.repository.FilmRepository;
import com.example.galaxyonejava.domain.usecase.GetListFilmUsecase;
import com.example.galaxyonejava.domain.usecase.GetListFilmUsecaseImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class UsecaseModule {

    @Provides
    GetListFilmUsecase providesGetListFilmUsecase(FilmRepository filmRepository) {
        return new GetListFilmUsecaseImpl(filmRepository);
    }
}
