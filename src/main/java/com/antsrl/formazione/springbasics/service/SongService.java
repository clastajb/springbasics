package com.antsrl.formazione.springbasics.service;

import com.antsrl.formazione.springbasics.uimodel.Song;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongService {

    public List<Song> getAllSongs(){

        return Arrays.asList(
                        Song.builder()
                                .id(41L)
                                .title("Good Song")
                                .url("http://example.com/good_song")
                                .build(),
                        Song.builder()
                                .id(23L)
                                .title("Nice Song")
                                .url("http://example.com/nice_song")
                                .build(),
                        Song.builder()
                                .id(98L)
                                .title("Evil Song")
                                .url("http://example.com/evil_song")
                                .build()
                );
    }
}
