package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.repository.SongRepository;
import com.antsrl.formazione.springbasics.uimodel.SongDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<SongDTO> getAllSongs(){

        songRepository.findAll();

        return List.of();
    }

    public void save(SongDTO song) {
        songRepository.save(null);
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
