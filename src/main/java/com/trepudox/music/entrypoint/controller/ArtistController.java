package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.CreateArtistRequestToArtistModelMapper;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import com.trepudox.music.entrypoint.request.CreateArtistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createArtist(@RequestBody CreateArtistRequest createArtistRequest) {
        ArtistModel artistModel = CreateArtistRequestToArtistModelMapper.map(createArtistRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(artistRepository.save(artistModel));
    }

}
