package com.trepudox.music.core.usecase.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.github.javafaker.Faker;
import com.trepudox.music.core.exception.NotFoundException;
import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.dataprovider.repository.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class GetArtistModelByIdUseCaseTest {

    @InjectMocks
    private GetArtistModelByIdUseCase getArtistModelByIdUseCase;

    @Mock
    private ArtistRepository artistRepository;

    @Test
    void mustThrowNotFoundExceptionWhenNoArtistIsFound() {
        Long id = 10L;

        when(artistRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException ex = assertThrows(NotFoundException.class, () -> getArtistModelByIdUseCase.get(id));
        assertEquals(id, ex.getId());
    }

    @Test
    void mustNotThrowExceptionWhenAnArtistIsFound() {
        Long id = 10L;
        ArtistModel expectedArtistModel = dummyArtistModel();

        when(artistRepository.findById(id)).thenReturn(Optional.of(expectedArtistModel));

        ArtistModel actualArtistModel = assertDoesNotThrow(() -> getArtistModelByIdUseCase.get(id));
        assertEquals(expectedArtistModel, actualArtistModel);
    }

    private ArtistModel dummyArtistModel() {
        Faker faker = Faker.instance();

        return ArtistModel.builder()
                .id(faker.number().randomNumber())
                .name(faker.name().name())
                .albums(List.of())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

}
