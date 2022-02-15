package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.core.usecase.IGetMusicModelByIdUseCase;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.dataprovider.repository.MusicRepository;
import com.trepudox.music.entity.enums.EntityEnums;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMusicModelByIdUseCase implements IGetMusicModelByIdUseCase {

    private final MusicRepository musicRepository;

    @Override
    public MusicModel get(Long id) {
        return musicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EntityEnums.MUSIC, id));
    }

}
