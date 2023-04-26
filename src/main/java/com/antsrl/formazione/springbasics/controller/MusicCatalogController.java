package com.antsrl.formazione.springbasics.controller;

import com.antsrl.formazione.springbasics.service.SongService;
import com.antsrl.formazione.springbasics.uimodel.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MusicCatalogController {

    @Autowired
    SongService songService;

    @RequestMapping(method= RequestMethod.GET, path="/")
    public String listAllSongs(Model model){

        List<Song> songList = songService.getAllSongs();

        model.addAttribute("songList", songList);

        return "music_catalog";
    }

    @RequestMapping(method = RequestMethod.POST, path="/")
    public String addSong(@ModelAttribute Song song, Model model){

        return "music_catalog";
    }
}
