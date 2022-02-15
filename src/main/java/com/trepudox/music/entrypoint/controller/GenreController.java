package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.GenreMapper;
import com.trepudox.music.core.usecase.IGetGenreModelByIdUseCase;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import com.trepudox.music.entrypoint.request.CreateGenreRequest;
import com.trepudox.music.entrypoint.response.GenreResponse;
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
@RequestMapping("/genre")
public class GenreController {

    private final GenreRepository genreRepository;
    private final IGetGenreModelByIdUseCase getGenreModelByIdUseCase;

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<GenreResponse>> createGenre(@RequestBody @Valid CreateGenreRequest createGenreRequest,
                                                                     HttpServletRequest request) {

        GenreModel genreModel = GenreMapper.INSTANCE.createGenreRequestToGenreModel(createGenreRequest);
        GenreResponse genreResponse = GenreMapper.INSTANCE.genreModelToGenreResponse(genreRepository.save(genreModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(GlobalResponseFactory.build(genreResponse, request.getRequestURI()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GlobalResponse<GenreResponse>> getGenreById(@PathVariable Long id,
                                                                      HttpServletRequest request) {
        GenreModel genreModel = getGenreModelByIdUseCase.get(id);
        GenreResponse response = GenreMapper.INSTANCE.genreModelToGenreResponse(genreModel);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(response, request.getRequestURI()));
    }

}
