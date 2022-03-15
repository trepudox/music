package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.AlbumMapper;
import com.trepudox.music.core.usecase.IGetAlbumModelByIdUseCase;
import com.trepudox.music.core.usecase.IGetAlbumModelListByNameUseCase;
import com.trepudox.music.core.usecase.IGetAllAlbumModelUseCase;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/album")
@CrossOrigin("*")
public class AlbumController {

    private final AlbumRepository albumRepository;
    private final IGetAllAlbumModelUseCase getAllAlbumModelUseCase;
    private final IGetAlbumModelByIdUseCase getAlbumModelByIdUseCase;
    private final IGetAlbumModelListByNameUseCase getAlbumModelListByName;

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<AlbumResponse>> createAlbum(@RequestBody @Valid CreateAlbumRequest createAlbumRequest,
                                                                     HttpServletRequest request) {

        AlbumModel albumModel = AlbumMapper.INSTANCE.createAlbumRequestToAlbumModel(createAlbumRequest);
        AlbumResponse albumResponse = AlbumMapper.INSTANCE.albumModelToAlbumResponse(albumRepository.save(albumModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(GlobalResponseFactory.build(albumResponse, request.getRequestURI()));
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<AlbumResponse>>> getAllAlbums(HttpServletRequest request) {
        List<AlbumModel> albumModelList = getAllAlbumModelUseCase.get();
        List<AlbumResponse> albumResponseList = AlbumMapper.INSTANCE.albumModelListToAlbumResponseList(albumModelList);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(albumResponseList, request.getRequestURI()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GlobalResponse<AlbumResponse>> getAlbumById(@PathVariable Long id,
                                                                      HttpServletRequest request) {
        AlbumModel albumModel = getAlbumModelByIdUseCase.get(id);
        AlbumResponse albumResponse = AlbumMapper.INSTANCE.albumModelToAlbumResponse(albumModel);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(albumResponse, request.getRequestURI()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GlobalResponse<List<AlbumResponse>>> getAlbumsByName(@PathVariable String name,
                                                                                  HttpServletRequest request) {
        List<AlbumModel> albumModelList = getAlbumModelListByName.get(name);
        List<AlbumResponse> albumResponseList = AlbumMapper.INSTANCE.albumModelListToAlbumResponseList(albumModelList);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(albumResponseList, request.getRequestURI()));
    }

}
