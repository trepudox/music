package com.trepudox.music.dataprovider.repository;

import com.trepudox.music.dataprovider.model.ArtistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistModel, Long> {

    List<ArtistModel> findAllByNameContainingIgnoreCase(String name);

}
