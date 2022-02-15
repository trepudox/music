package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.core.usecase.IGetAlbumModelByIdUseCase;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.repository.AlbumRepository;
import com.trepudox.music.entity.enums.EntityEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAlbumModelByIdUseCase implements IGetAlbumModelByIdUseCase {

    private final AlbumRepository albumRepository;

    @Override
    public AlbumModel get(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EntityEnums.ALBUM, id));
    }

}
