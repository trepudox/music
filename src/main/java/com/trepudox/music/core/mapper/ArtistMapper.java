package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.ArtistModel;
import com.trepudox.music.entrypoint.request.CreateArtistRequest;
import com.trepudox.music.entrypoint.response.ArtistResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    ArtistModel createArtistToArtistModel(CreateArtistRequest createArtistRequest);

    ArtistResponse artistModelToArtistResponse(ArtistModel artistModel);

    List<ArtistResponse> artistModelListToArtistResponseList(List<ArtistModel> artistModelList);

}
