package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.entrypoint.response.AlbumResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlbumModelToAlbumResponseMapper {

    public static AlbumResponse map(AlbumModel albumModel) {
        return AlbumResponse.builder()
                .id(albumModel.getId())
                .name(albumModel.getName())
                .artist(ArtistModelToArtistResponseMapper.map(albumModel.getArtist()))
                .tracks(albumModel.getTracks().stream()
                        .map(MusicModelToMusicResponseMapper::map)
                        .collect(Collectors.toList()))
                .releaseDate(albumModel.getReleaseDate())
                .build();
    }

}
