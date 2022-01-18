package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.entrypoint.request.CreateArtistRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateArtistRequestToArtistModelMapper {

    public static ArtistModel map(CreateArtistRequest createArtistRequest) {
        return ArtistModel.builder()
                .id(null)
                .name(createArtistRequest.getName())
                .build();
    }

}
