package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.entity.Artist;
import com.trepudox.music.entrypoint.request.CreateArtistRequest;
import com.trepudox.music.entrypoint.response.ArtistResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    Artist createArtistRequestToArtist(CreateArtistRequest createArtistRequest);

    ArtistModel artistToArtistModel(Artist artist);

    ArtistResponse artistModelToArtistResponse(ArtistModel artistModel);

}
