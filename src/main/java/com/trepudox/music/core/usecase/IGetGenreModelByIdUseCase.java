package com.trepudox.music.core.usecase;

import com.trepudox.music.dataprovider.model.GenreModel;

public interface IGetGenreModelByIdUseCase {

    GenreModel get(Long id);

}
