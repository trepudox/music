package com.trepudox.music.dataprovider.repository;

import com.trepudox.music.dataprovider.model.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel, Long> {

    List<GenreModel> findAllByNameContainingIgnoreCase(String name);

}
