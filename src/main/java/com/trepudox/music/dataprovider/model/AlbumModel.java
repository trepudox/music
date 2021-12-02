package com.trepudox.music.dataprovider.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "album")
public class AlbumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(targetEntity = ArtistModel.class, cascade = CascadeType.ALL, optional = false)
    private ArtistModel artist;

    @OneToMany(targetEntity = MusicModel.class, cascade = CascadeType.ALL, mappedBy = "album")
    private List<MusicModel> tracks;

    private LocalDate releaseDate;

}
