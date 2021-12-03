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

    @ManyToOne(targetEntity = GenreModel.class, cascade = CascadeType.ALL, optional = false)
    private GenreModel genre;

    @ManyToOne(targetEntity = ArtistModel.class, cascade = CascadeType.ALL, optional = false)
    private ArtistModel artist;

    @ManyToOne(targetEntity = AlbumModel.class, cascade = CascadeType.ALL)
    private AlbumModel album;

    @Column(nullable = false)
    private LocalDate releaseDate;

}
