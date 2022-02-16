package com.trepudox.music.util.tests;

import com.github.javafaker.Faker;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.model.MusicModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestsDummyData {

    private static final Faker faker = Faker.instance();

    public static ArtistModel dummyArtistModel() {
        return ArtistModel.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().name())
                .albums(List.of())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

    public static AlbumModel dummyAlbumModel() {
        return AlbumModel.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().name())
                .artist(dummyArtistModel())
                .releaseDate(LocalDate.now())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

    public static GenreModel dummyGenreModel() {
        return GenreModel.builder()
                .name(faker.name().name())
                .description(faker.name().name())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

    public static MusicModel dummyMusicModel() {
        return MusicModel.builder()
                .name(faker.name().name())
                .genre(dummyGenreModel())
                .artist(dummyArtistModel())
                .album(dummyAlbumModel())
                .releaseDate(LocalDate.now())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

}
