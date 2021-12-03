package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.entrypoint.request.CreateAlbumRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateAlbumRequestToAlbumModelMapper {

    public static AlbumModel map(CreateAlbumRequest createAlbumRequest) {
        return AlbumModel.builder()
                .id(null)
                .name(createAlbumRequest.getName())
                .artist(ArtistModel.builder()
                        .id(createAlbumRequest.getArtist().getId())
                        .build())
                .releaseDate(StringToLocalDateMapper.map(createAlbumRequest.getReleaseDate()))
                .build();
    }

}
