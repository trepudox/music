package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.AlbumMapper;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.repository.AlbumRepository;
import com.trepudox.music.entrypoint.request.CreateAlbumRequest;
import com.trepudox.music.entrypoint.response.AlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRepository albumRepository;

    @PostMapping("/create")
    public ResponseEntity<AlbumResponse> createAlbum(@RequestBody CreateAlbumRequest createAlbumRequest) {
        AlbumModel albumModel = AlbumMapper.INSTANCE.createAlbumRequestToAlbumModel(createAlbumRequest);
        AlbumResponse albumResponse = AlbumMapper.INSTANCE.albumModelToAlbumResponse(albumRepository.save(albumModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(albumResponse);
    }

}
