package com.trepudox.music.core.usecase.impl;

import com.trepudox.music.core.usecase.IGetAllMusicModelUseCase;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.dataprovider.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllMusicModelUseCase implements IGetAllMusicModelUseCase {

    private final MusicRepository musicRepository;

    @Override
    public List<MusicModel> get() {
        return musicRepository.findAll();
    }

}
