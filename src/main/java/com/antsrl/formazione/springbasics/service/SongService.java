package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.domain.Song;
import com.antsrl.formazione.springbasics.repository.SongRepository;
import com.antsrl.formazione.springbasics.uimodel.SongDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ConversionService conversionService;

    @Transactional
    public List<SongDTO> getAllSongs(){

        return songRepository.findAll().stream()
                .map(song -> conversionService.convert(song, SongDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(SongDTO song) {
        songRepository.save(
                Objects.requireNonNull(
                        conversionService.convert(song, Song.class)));
    }

    @Transactional
    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
