package com.trepudox.music.dataprovider.repository;

import com.trepudox.music.dataprovider.model.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumModel, Long> {

    List<AlbumModel> findAllByNameContainingIgnoreCase(String name);

}
