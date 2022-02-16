package com.trepudox.music.core.usecase.impl;

import static com.trepudox.music.util.tests.TestsDummyData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.dataprovider.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class GetAlbumModelByIdUseCaseTest {

    @InjectMocks
    private GetAlbumModelByIdUseCase getAlbumModelByIdUseCase;

    @Mock
    private AlbumRepository albumRepository;

    @Test
    void mustThrowNotFoundExceptionWhenNoAlbumIsFound() {
        long id = 10L;

        when(albumRepository.findById(anyLong())).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> getAlbumModelByIdUseCase.get(id));
        assertEquals(id, ex.getId());
    }

    @Test
    void mustNotThrowExceptionWhenAnAlbumIsFound() {
        long id = 10L;
        AlbumModel expectedAlbumModel = dummyAlbumModel();

        when(albumRepository.findById(anyLong())).thenReturn(Optional.of(expectedAlbumModel));

        AlbumModel actualAlbumModel = assertDoesNotThrow(() -> getAlbumModelByIdUseCase.get(id));
        assertEquals(expectedAlbumModel, actualAlbumModel);
    }

}
