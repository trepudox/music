package com.trepudox.music.entrypoint.controller;

import com.trepudox.music.core.mapper.MusicMapper;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.dataprovider.repository.MusicRepository;
import com.trepudox.music.entrypoint.request.CreateMusicRequest;
import com.trepudox.music.entrypoint.response.MusicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/music")
public class MusicController {

    private final MusicRepository musicRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<MusicResponse> createMusic(@RequestBody CreateMusicRequest createMusicRequest) {
        MusicModel musicModel = MusicMapper.INSTANCE.createMusicRequestToMusicModel(createMusicRequest);
        MusicResponse response = MusicMapper.INSTANCE.musicModelToMusicResponse(musicRepository.save(musicModel));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
