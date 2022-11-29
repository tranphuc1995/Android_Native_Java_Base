package com.example.galaxyonejava.data.di;

import com.example.galaxyonejava.data.FilmRepositoryImpl;
import com.example.galaxyonejava.data.api.FilmApi;
import com.example.galaxyonejava.domain.repository.FilmRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    FilmRepository provideFilmRepository(FilmApi filmApi) {
        return new FilmRepositoryImpl(filmApi);
    }
}
