package com.antsrl.formazione.springbasics.controller;

import com.antsrl.formazione.springbasics.service.SongService;
import com.antsrl.formazione.springbasics.uimodel.Song;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("song", Song
                .builder()
                .build());

        return "music_catalog";
    }

    @RequestMapping(method = RequestMethod.POST, path="/")
    public String addSong(@Valid @ModelAttribute Song song, BindingResult bindingResult, Model model){

        List<Song> songList = songService.getAllSongs();

        model.addAttribute("songList", songList);

        if(bindingResult.hasErrors()){
            return "music_catalog";
        }

        songService.save(song);

        return "redirect:/";
    }
}
