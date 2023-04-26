package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.uimodel.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SongService {

    private final static List<Song> songList = Collections.synchronizedList(new ArrayList<>());

    private final static AtomicLong songListLatestId = new AtomicLong();

    static{

        addSongInternal(Song.builder()
                .title("Good Song")
                .url("http://example.com/good_song")
                .build());

        addSongInternal(Song.builder()
                .title("Nice Song")
                .url("http://example.com/nice_song")
                .build());

        addSongInternal(Song.builder()
                .title("Evil Song")
                .url("http://example.com/evil_song")
                .build());
    }

    private static void addSongInternal(Song song) {

        if(Objects.isNull(song.getId())){
            song.setId(songListLatestId.incrementAndGet());
        }

        songList.add(song);
    }

    public List<Song> getAllSongs(){
        return songList;
    }

    public void save(Song song) {
        addSongInternal(song);
    }
}
