package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.entity.Album;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AlbumToAlbumModelMapper {

    public static AlbumModel map(Album album) {
        return AlbumModel.builder()
                .id(null)
                .name(album.getName())
                .artist(ArtistToArtistModelMapper.map(album.getArtist()))
                .tracks(album.getTracks().stream()
                        .map(MusicToMusicModelMapper::map)
                        .collect(Collectors.toList()))
                .releaseDate(album.getReleaseDate())
                .build();
    }

}
