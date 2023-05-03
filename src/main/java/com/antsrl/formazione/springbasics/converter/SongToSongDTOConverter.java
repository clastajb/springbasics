package com.antsrl.formazione.springbasics.converter;

import com.antsrl.formazione.springbasics.domain.Song;
import com.antsrl.formazione.springbasics.uimodel.SongDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SongToSongDTOConverter implements Converter<Song, SongDTO> {

    @Override
    public SongDTO convert(Song source) {

        return SongDTO.builder()
                .id(source.getId())
                .title(source.getTitle())
                .url(source.getUrl())
                .build();
    }
}
