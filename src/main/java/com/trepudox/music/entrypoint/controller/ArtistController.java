package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.ArtistMapper;
import com.trepudox.music.core.usecase.IGetArtistModelByIdUseCase;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import com.trepudox.music.entrypoint.request.CreateArtistRequest;
import com.trepudox.music.entrypoint.response.ArtistResponse;
import com.trepudox.music.entrypoint.response.global.GlobalResponse;
import com.trepudox.music.util.factory.GlobalResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;
    private final IGetArtistModelByIdUseCase getArtistModelByIdUseCase;

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<ArtistResponse>> createArtist(@RequestBody @Valid CreateArtistRequest createArtistRequest,
                                                                       HttpServletRequest request) {

        ArtistModel artistModel = ArtistMapper.INSTANCE.createArtistToArtistModel(createArtistRequest);
        ArtistResponse artistResponse = ArtistMapper.INSTANCE.artistModelToArtistResponse(artistRepository.save(artistModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(GlobalResponseFactory.build(artistResponse, request.getRequestURI()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GlobalResponse<ArtistResponse>> getArtistById(@PathVariable Long id,
                                                                        HttpServletRequest request) {
        ArtistModel artistModel = getArtistModelByIdUseCase.get(id);
        ArtistResponse artistResponse = ArtistMapper.INSTANCE.artistModelToArtistResponse(artistModel);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(artistResponse, request.getRequestURI()));
    }

}
