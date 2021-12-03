package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.AlbumModel;

public interface IGetAlbumModelByIdUseCase {

    AlbumModel get(Long id);

}
