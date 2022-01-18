package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.entrypoint.response.ArtistResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArtistModelToArtistResponseMapper {

    public static ArtistResponse map(ArtistModel artistModel) {
        return ArtistResponse.builder()
                .id(artistModel.getId())
                .name(artistModel.getName())
                .albums(artistModel.getAlbums() == null ? null :
                        artistModel.getAlbums().stream()
                        .map(AlbumModelToAlbumResponseMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }

}
