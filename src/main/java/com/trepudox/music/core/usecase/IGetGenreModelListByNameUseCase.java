package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.GenreModel;

import java.util.List;

public interface IGetGenreModelListByNameUseCase {

    List<GenreModel> get(String name);

}
