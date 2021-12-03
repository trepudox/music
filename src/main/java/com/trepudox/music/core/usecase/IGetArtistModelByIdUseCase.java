package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.ArtistModel;

public interface IGetArtistModelByIdUseCase {

    ArtistModel get(Long id);

}
