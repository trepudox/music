package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.entrypoint.request.CreateMusicRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateMusicRequestToMusicModelMapper {

    public static MusicModel map(CreateMusicRequest createMusicRequest) {
        return MusicModel.builder()
                .id(null)
                .name(createMusicRequest.getName())
                .genre(GenreModel.builder()
                        .id(createMusicRequest.getGenre().getId())
                        .build())
                .artist(ArtistModel.builder()
                        .id(createMusicRequest.getArtist().getId())
                        .build())
                .album(AlbumModel.builder()
                        .id(createMusicRequest.getAlbum().getId())
                        .build())
                .releaseDate(StringToLocalDateMapper.map(createMusicRequest.getReleaseDate()))
                .build();
    }

}
