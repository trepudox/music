package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.entity.Genre;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreToGenreModelMapper {

    public static GenreModel map(Genre genre) {
        return GenreModel.builder()
                .id(null)
                .name(genre.getName())
                .description(genre.getDescription())
                .tracks(genre.getMusics() != null ?
                        genre.getMusics().stream()
                        .map(MusicToMusicModelMapper::map)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }
}
