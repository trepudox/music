package com.trepudox.music.dataprovider.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "album")
public class AlbumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = ArtistModel.class, optional = false)
    private ArtistModel artist;

    @OneToMany(targetEntity = MusicModel.class, cascade = CascadeType.ALL, mappedBy = "album")
    private List<MusicModel> tracks;

    @Column(nullable = false)
    private LocalDate releaseDate;

}
