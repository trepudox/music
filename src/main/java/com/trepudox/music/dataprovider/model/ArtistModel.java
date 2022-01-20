package com.trepudox.music.dataprovider.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "artist")
public class ArtistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = AlbumModel.class, cascade = CascadeType.ALL, mappedBy = "artist")
    private List<AlbumModel> albums;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedDate
    private LocalDateTime createdDate;

}
