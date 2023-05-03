package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.uimodel.SongDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SongService {

    private final static List<SongDTO> songList = Collections.synchronizedList(new ArrayList<>());

    private final static AtomicLong songListLatestId = new AtomicLong();

    static{

        addSongInternal(SongDTO.builder()
                .title("Good Song")
                .url("http://example.com/good_song")
                .build());

        addSongInternal(SongDTO.builder()
                .title("Nice Song")
                .url("http://example.com/nice_song")
                .build());

        addSongInternal(SongDTO.builder()
                .title("Evil Song")
                .url("http://example.com/evil_song")
                .build());
    }

    private static void addSongInternal(SongDTO song) {

        if(Objects.isNull(song.getId())){
            song.setId(songListLatestId.incrementAndGet());
        }

        songList.add(song);
    }

    public List<SongDTO> getAllSongs(){
        return songList;
    }

    public void save(SongDTO song) {
        addSongInternal(song);
    }

    public void delete(Long id) {
        songList.stream()
                .filter(song -> Objects.equals(id, song.getId()))
                .findFirst()
                .ifPresent(songList::remove);
    }
}
