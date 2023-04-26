package com.antsrl.formazione.springbasics.controller;

import com.antsrl.formazione.springbasics.uimodel.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class MusicCatalogController {

    @RequestMapping(method= RequestMethod.GET, path="/")
    public String listAllSongs(Model model){

        List<Song> songList = Arrays.asList(
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

        model.addAttribute("songList", songList);

        return "music_catalog";
    }
}
