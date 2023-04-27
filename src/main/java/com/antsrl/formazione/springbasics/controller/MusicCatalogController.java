package com.antsrl.formazione.springbasics.controller;

import com.antsrl.formazione.springbasics.service.SongService;
import com.antsrl.formazione.springbasics.uimodel.Song;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = {RequestMethod.GET}, path = "/delete/{id}")
    public String deleteSongGet(@PathVariable("id") Long id, Model model){

        return deleteSongInternal(id, model);
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "/delete")
    public String deleteSongPost(@RequestParam("id") Long id, Model model){

        deleteSongInternal(id, model);

        return "redirect:/";
    }

    private String deleteSongInternal(Long id, Model model) {

        songService.delete(id);

        List<Song> songList = songService.getAllSongs();

        model.addAttribute("songList", songList);
        model.addAttribute("song", Song
                .builder()
                .build());

        return "music_catalog";
    }
}
