package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.MusicModel;

public interface IGetMusicModelByIdUseCase {

    MusicModel get(Long id);

}
