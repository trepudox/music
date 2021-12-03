package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.entity.Artist;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArtistToArtistModelMapper {

    public static ArtistModel map(Artist artist) {
        return ArtistModel.builder()
                .id(null)
                .name(artist.getName())
                .albums(artist.getAlbums() != null ?
                        artist.getAlbums().stream()
                        .map(AlbumToAlbumModelMapper::map)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

}
