package com.trepudox.music.core.mapper;

import com.trepudox.music.dataprovider.model.MusicModel;
import com.trepudox.music.entrypoint.request.CreateMusicRequest;
import com.trepudox.music.entrypoint.response.MusicResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MusicMapper {

    MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    MusicModel createMusicRequestToMusicModel(CreateMusicRequest createMusicRequest);

    MusicResponse musicModelToMusicResponse(MusicModel musicModel);

    List<MusicResponse> musicModelListToMusicResponseList(List<MusicModel> musicModelList);

}
