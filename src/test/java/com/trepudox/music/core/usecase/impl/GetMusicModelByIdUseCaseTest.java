package com.trepudox.music.core.usecase.impl;

import static com.trepudox.music.util.tests.TestsDummyData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.dataprovider.repository.MusicRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class GetMusicModelByIdUseCaseTest {

    @InjectMocks
    private GetMusicModelByIdUseCase getMusicModelByIdUseCase;

    @Mock
    private MusicRepository musicRepository;

    @Test
    void mustThrowNotFoundExceptionWhenNoMusicIsFound() {
        long id = 10L;

        when(musicRepository.findById(anyLong())).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> getMusicModelByIdUseCase.get(id));
        assertEquals(id, ex.getId());
    }

    @Test
    void mustNotThrowExceptionWhenAMusicIsFound() {
        long id = 10L;
        MusicModel expectedMusicModel = dummyMusicModel();

        when(musicRepository.findById(anyLong())).thenReturn(Optional.of(expectedMusicModel));

        MusicModel actualMusicModel = assertDoesNotThrow(() -> getMusicModelByIdUseCase.get(id));
        assertEquals(expectedMusicModel, actualMusicModel);
    }

}
