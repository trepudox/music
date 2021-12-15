package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.entrypoint.response.GenreResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreModelToGenreResponseMapper {

    public static GenreResponse map(GenreModel genreModel) {
        return GenreResponse.builder()
                .id(genreModel.getId())
                .name(genreModel.getName())
                .description(genreModel.getDescription())
                .tracks(genreModel.getTracks().stream()
                        .map(MusicModelToMusicResponseMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }

}
