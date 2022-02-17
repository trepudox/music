package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetGenreModelListByNameUseCase;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetGenreModelListByNameUseCase implements IGetGenreModelListByNameUseCase {

    private final GenreRepository genreRepository;

    @Override
    public List<GenreModel> get(String name) {
        return genreRepository.findAllByNameContainingIgnoreCase(name);
    }

}
