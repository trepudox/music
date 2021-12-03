package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetArtistModelByIdUseCase;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetArtistModelByIdUseCase implements IGetArtistModelByIdUseCase {

    private final ArtistRepository artistRepository;

    public ArtistModel get(Long id) {
        return artistRepository.getById(id);
    }

}
