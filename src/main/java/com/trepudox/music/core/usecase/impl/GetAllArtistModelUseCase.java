package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetAllArtistModelUseCase;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllArtistModelUseCase implements IGetAllArtistModelUseCase {

    private final ArtistRepository artistRepository;

    @Override
    public List<ArtistModel> get() {
        return artistRepository.findAll();
    }

}
