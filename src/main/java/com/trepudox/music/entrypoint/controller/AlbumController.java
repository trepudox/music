package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.AlbumModelToAlbumResponseMapper;
import com.trepudox.music.core.mapper.CreateAlbumRequestToAlbumModelMapper;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.repository.AlbumRepository;
import com.trepudox.music.entrypoint.request.CreateAlbumRequest;
import com.trepudox.music.entrypoint.response.AlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/album")
public class AlbumController {

    private final AlbumRepository albumRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<AlbumResponse> createAlbum(@RequestBody CreateAlbumRequest createAlbumRequest) {
        AlbumModel albumModel = CreateAlbumRequestToAlbumModelMapper.map(createAlbumRequest);
        AlbumResponse response = AlbumModelToAlbumResponseMapper.map(albumRepository.save(albumModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}