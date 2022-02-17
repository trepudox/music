package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetMusicModelListByNameUseCase;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.dataprovider.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetMusicModelListByNameUseCase implements IGetMusicModelListByNameUseCase {

    private final MusicRepository musicRepository;

    @Override
    public List<MusicModel> get(String name) {
        return musicRepository.findAllByNameContainingIgnoreCase(name);
    }

}
