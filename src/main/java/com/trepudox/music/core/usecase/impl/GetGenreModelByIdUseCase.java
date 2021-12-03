package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetGenreModelByIdUseCase;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetGenreModelByIdUseCase implements IGetGenreModelByIdUseCase {

    private final GenreRepository genreRepository;

    @Override
    public GenreModel get(Long id) {
        return genreRepository.getById(id);
    }

}
