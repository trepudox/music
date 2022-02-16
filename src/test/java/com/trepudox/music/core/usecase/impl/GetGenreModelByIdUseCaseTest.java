package com.trepudox.music.core.usecase.impl;

import static com.trepudox.music.util.tests.TestsDummyData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.dataprovider.model.GenreModel;
import com.trepudox.music.dataprovider.repository.GenreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class GetGenreModelByIdUseCaseTest {

    @InjectMocks
    private GetGenreModelByIdUseCase getGenreModelByIdUseCase;

    @Mock
    private GenreRepository genreRepository;

    @Test
    void mustThrowNotFoundExceptionWhenNoGenreIsFound() {
        long id = 10L;

        when(genreRepository.findById(anyLong())).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> getGenreModelByIdUseCase.get(id));
        assertEquals(id, ex.getId());
    }

    @Test
    void mustNotThrowExceptionWhenAGenreIsFound() {
        long id = 10L;
        GenreModel expectedGenreModel = dummyGenreModel();

        when(genreRepository.findById(anyLong())).thenReturn(Optional.of(expectedGenreModel));

        GenreModel actualGenreModel = assertDoesNotThrow(() -> getGenreModelByIdUseCase.get(id));
        assertEquals(expectedGenreModel, actualGenreModel);
    }

}
