package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.CreateGenreRequestToGenreModelMapper;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import com.trepudox.music.entrypoint.request.CreateGenreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/genre")
public class GenreController {

    private final GenreRepository genreRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createGenre(@RequestBody CreateGenreRequest createGenreRequest) {
        GenreModel genreModel = CreateGenreRequestToGenreModelMapper.map(createGenreRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreRepository.save(genreModel));
    }

}
