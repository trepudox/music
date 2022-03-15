package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetAllAlbumModelUseCase;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllAlbumModelUseCase implements IGetAllAlbumModelUseCase {

    private final AlbumRepository albumRepository;

    @Override
    public List<AlbumModel> get() {
        return albumRepository.findAll();
    }

}
