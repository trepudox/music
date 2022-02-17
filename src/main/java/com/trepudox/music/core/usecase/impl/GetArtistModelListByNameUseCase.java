package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetArtistModelListByNameUseCase;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetArtistModelListByNameUseCase implements IGetArtistModelListByNameUseCase {

    private final ArtistRepository artistRepository;

    @Override
    public List<ArtistModel> get(String name) {
        return artistRepository.findAllByNameContainingIgnoreCase(name);
    }

}
