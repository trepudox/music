package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.entrypoint.request.CreateGenreRequest;
import com.trepudox.music.entrypoint.response.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreModel createGenreRequestToGenreModel(CreateGenreRequest createGenreRequest);

    GenreResponse genreModelToGenreResponse(GenreModel genreModel);

    List<GenreResponse> genreModelListToGenreResponseList(List<GenreModel> genreModelList);

}
