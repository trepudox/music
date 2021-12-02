package com.trepudox.music.dataprovider.model;

import com.trepudox.music.entity.Album;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "artist")
public class ArtistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = AlbumModel.class, cascade = CascadeType.ALL, mappedBy = "artist")
    private List<AlbumModel> albums;

}
