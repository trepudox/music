package com.trepudox.music.dataprovider.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "music")
public class MusicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = GenreModel.class, optional = false)
    private GenreModel genre;

    @ManyToOne(targetEntity = ArtistModel.class, optional = false)
    private ArtistModel artist;

    @ManyToOne(targetEntity = AlbumModel.class)
    private AlbumModel album;

    @Column(nullable = false)
    private LocalDate releaseDate;

}
