package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.GenreMapper;
import com.trepudox.music.core.usecase.IGetAllGenreModelUseCase;
import com.trepudox.music.core.usecase.IGetGenreModelByIdUseCase;
import com.trepudox.music.core.usecase.IGetGenreModelListByNameUseCase;
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
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
@CrossOrigin("*")
public class GenreController {

    private final GenreRepository genreRepository;
    private final IGetAllGenreModelUseCase getAllGenreModelUseCase;
    private final IGetGenreModelByIdUseCase getGenreModelByIdUseCase;
    private final IGetGenreModelListByNameUseCase getGenreModelListByNameUseCase;

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<GenreResponse>> createGenre(@RequestBody @Valid CreateGenreRequest createGenreRequest,
                                                                     HttpServletRequest request) {

        GenreModel genreModel = GenreMapper.INSTANCE.createGenreRequestToGenreModel(createGenreRequest);
        GenreResponse genreResponse = GenreMapper.INSTANCE.genreModelToGenreResponse(genreRepository.save(genreModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(GlobalResponseFactory.build(genreResponse, request.getRequestURI()));
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<GenreResponse>>> getAllGenres(HttpServletRequest request) {
        List<GenreModel> genreModelList = getAllGenreModelUseCase.get();
        List<GenreResponse> genreResponseList = GenreMapper.INSTANCE.genreModelListToGenreResponseList(genreModelList);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(genreResponseList, request.getRequestURI()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GlobalResponse<GenreResponse>> getGenreById(@PathVariable Long id,
                                                                      HttpServletRequest request) {
        GenreModel genreModel = getGenreModelByIdUseCase.get(id);
        GenreResponse response = GenreMapper.INSTANCE.genreModelToGenreResponse(genreModel);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(response, request.getRequestURI()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GlobalResponse<List<GenreResponse>>> getGenresByName(@PathVariable String name,
                                                                               HttpServletRequest request) {

        List<GenreModel> genreModelList = getGenreModelListByNameUseCase.get(name);
        List<GenreResponse> genreResponseList = GenreMapper.INSTANCE.genreModelListToGenreResponseList(genreModelList);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(genreResponseList, request.getRequestURI()));
    }

}
