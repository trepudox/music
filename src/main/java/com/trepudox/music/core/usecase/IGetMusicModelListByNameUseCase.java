package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.MusicModel;

import java.util.List;

public interface IGetMusicModelListByNameUseCase {

    List<MusicModel> get(String name);

}
