package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.AlbumModel;

import java.util.List;

public interface IGetAlbumModelListByNameUseCase {

    List<AlbumModel> get(String name);

}
