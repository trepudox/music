package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.ArtistModel;

import java.util.List;

public interface IGetArtistModelListByNameUseCase {

    List<ArtistModel> get(String name);

}
