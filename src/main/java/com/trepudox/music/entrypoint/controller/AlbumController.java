package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.AlbumMapper;
import com.trepudox.music.core.usecase.IGetAlbumModelByIdUseCase;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.repository.AlbumRepository;
import com.trepudox.music.entrypoint.request.CreateAlbumRequest;
import com.trepudox.music.entrypoint.response.AlbumResponse;
import com.trepudox.music.entrypoint.response.global.GlobalResponse;
import com.trepudox.music.util.factory.GlobalResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRepository albumRepository;
    private final IGetAlbumModelByIdUseCase getAlbumModelByIdUseCase;

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<AlbumResponse>> createAlbum(@RequestBody @Valid CreateAlbumRequest createAlbumRequest) {
        AlbumModel albumModel = AlbumMapper.INSTANCE.createAlbumRequestToAlbumModel(createAlbumRequest);
        AlbumResponse albumResponse = AlbumMapper.INSTANCE.albumModelToAlbumResponse(albumRepository.save(albumModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(GlobalResponseFactory.build(albumResponse));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GlobalResponse<AlbumResponse>> getAlbumById(@PathVariable Long id) {
        AlbumModel albumModel = getAlbumModelByIdUseCase.get(id);
        AlbumResponse response = AlbumMapper.INSTANCE.albumModelToAlbumResponse(albumModel);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(response));
    }

}
