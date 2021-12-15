package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.entrypoint.response.MusicResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MusicModelToMusicResponseMapper {

    public static MusicResponse map(MusicModel musicModel) {
        return MusicResponse.builder()
                .id(musicModel.getId())
                .name(musicModel.getName())
                .genre(GenreModelToGenreResponseMapper.map(musicModel.getGenre()))
                .artist(ArtistModelToArtistResponseMapper.map(musicModel.getArtist()))
                .album(AlbumModelToAlbumResponseMapper.map(musicModel.getAlbum()))
                .releaseDate(musicModel.getReleaseDate())
                .build();
    }

}
