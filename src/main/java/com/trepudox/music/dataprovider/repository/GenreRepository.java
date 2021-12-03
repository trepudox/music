package com.trepudox.music.dataprovider.repository;

import com.trepudox.music.dataprovider.model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {
}
