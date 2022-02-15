package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.core.usecase.IGetArtistModelByIdUseCase;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import com.trepudox.music.entity.enums.EntityEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetArtistModelByIdUseCase implements IGetArtistModelByIdUseCase {

    private final ArtistRepository artistRepository;

    public ArtistModel get(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EntityEnums.ARTIST, id));
    }

}
