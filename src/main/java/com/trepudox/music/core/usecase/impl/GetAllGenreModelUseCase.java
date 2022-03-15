package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetAllGenreModelUseCase;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllGenreModelUseCase implements IGetAllGenreModelUseCase {

    private final GenreRepository genreRepository;

    @Override
    public List<GenreModel> get() {
        return genreRepository.findAll();
    }

}
