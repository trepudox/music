package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.entrypoint.request.CreateGenreRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateGenreRequestToGenreModelMapper {

    public static GenreModel map(CreateGenreRequest createGenreRequest) {
        return GenreModel.builder()
                .id(null)
                .name(createGenreRequest.getName())
                .description(createGenreRequest.getDescription())
                .tracks(null)
                .build();
    }

}
