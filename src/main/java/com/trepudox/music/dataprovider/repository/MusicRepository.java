package com.trepudox.music.dataprovider.repository;

import com.trepudox.music.dataprovider.model.MusicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicModel, Long> {
}
