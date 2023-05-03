package com.antsrl.formazione.springbasics.converter;

import com.antsrl.formazione.springbasics.domain.Song;
import com.antsrl.formazione.springbasics.uimodel.SongDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SongDtoToSongConverter implements Converter<SongDTO, Song> {

    @Override
    public Song convert(SongDTO source) {

        Song destination = new Song();

        destination.setId(source.getId());
        destination.setTitle(source.getTitle());
        destination.setUrl(source.getUrl());

        return destination;
    }
}
