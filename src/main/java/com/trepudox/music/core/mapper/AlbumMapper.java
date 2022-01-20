package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.AlbumModel;
import com.trepudox.music.entrypoint.request.CreateAlbumRequest;
import com.trepudox.music.entrypoint.response.AlbumResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);

    AlbumModel createAlbumRequestToAlbumModel(CreateAlbumRequest createAlbumRequest);

    AlbumResponse albumModelToAlbumResponse(AlbumModel albumModel);

}
