package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.entity.Music;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MusicToMusicModelMapper {

    public static MusicModel map(Music music) {
        return MusicModel.builder()
                .id(null)
                .name(music.getName())
                .genre(GenreToGenreModelMapper.map(music.getGenre()))
                .artist(ArtistToArtistModelMapper.map(music.getArtist()))
                .album(AlbumToAlbumModelMapper.map(music.getAlbum()))
                .releaseDate(music.getReleaseDate())
                .build();
    }

}
