package com.trepudox.music.dataprovider.repository;

import com.trepudox.music.dataprovider.model.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumModel, Long> {
}
