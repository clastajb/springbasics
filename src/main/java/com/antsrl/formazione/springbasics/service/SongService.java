package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.uimodel.SongDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    public List<SongDTO> getAllSongs(){
        return List.of();
    }

    public void save(SongDTO song) {

    }

    public void delete(Long id) {

    }
}
