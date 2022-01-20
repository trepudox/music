package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.entity.Genre;
import com.trepudox.music.entrypoint.request.CreateGenreRequest;
import com.trepudox.music.entrypoint.response.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre createGenreRequestToGenre(CreateGenreRequest createGenreRequest);

    GenreModel genreToGenreModel(Genre genre);

    GenreResponse genreModelToGenreResponse(GenreModel genreModel);

}
