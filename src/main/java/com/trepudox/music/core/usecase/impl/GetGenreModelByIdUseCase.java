package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.core.usecase.IGetGenreModelByIdUseCase;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import com.trepudox.music.entity.enums.EntityEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetGenreModelByIdUseCase implements IGetGenreModelByIdUseCase {

    private final GenreRepository genreRepository;

    @Override
    public GenreModel get(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EntityEnums.GENRE, id));
    }

}
