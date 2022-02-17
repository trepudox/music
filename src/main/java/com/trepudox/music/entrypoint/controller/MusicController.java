package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.MusicMapper;
import com.trepudox.music.core.usecase.IGetMusicModelByIdUseCase;
import com.trepudox.music.core.usecase.IGetMusicModelListByNameUseCase;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.dataprovider.repository.MusicRepository;
import com.trepudox.music.entrypoint.request.CreateMusicRequest;
import com.trepudox.music.entrypoint.response.MusicResponse;
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
@RequestMapping("/music")
public class MusicController {

    private final MusicRepository musicRepository;
    private final IGetMusicModelByIdUseCase getMusicModelByIdUseCase;
    private final IGetMusicModelListByNameUseCase getMusicModelListByNameUseCase;

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<MusicResponse>> createMusic(@RequestBody @Valid CreateMusicRequest createMusicRequest,
                                                                     HttpServletRequest request) {

        MusicModel musicModel = MusicMapper.INSTANCE.createMusicRequestToMusicModel(createMusicRequest);
        MusicResponse musicResponse = MusicMapper.INSTANCE.musicModelToMusicResponse(musicRepository.save(musicModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(GlobalResponseFactory.build(musicResponse, request.getRequestURI()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GlobalResponse<MusicResponse>> getMusicById(@PathVariable Long id,
                                                                      HttpServletRequest request) {
        MusicModel musicModel = getMusicModelByIdUseCase.get(id);
        MusicResponse musicResponse = MusicMapper.INSTANCE.musicModelToMusicResponse(musicModel);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(musicResponse, request.getRequestURI()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GlobalResponse<List<MusicResponse>>> getMusicsByName(@PathVariable String name,
                                                                               HttpServletRequest request) {

        List<MusicModel> musicModelList = getMusicModelListByNameUseCase.get(name);
        List<MusicResponse> musicResponseList = MusicMapper.INSTANCE.musicModelListToMusicResponseList(musicModelList);

        return ResponseEntity.status(HttpStatus.OK).body(GlobalResponseFactory.build(musicResponseList, request.getRequestURI()));
    }

}
