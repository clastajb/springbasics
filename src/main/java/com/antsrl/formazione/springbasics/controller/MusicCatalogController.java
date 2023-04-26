package com.antsrl.formazione.springbasics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MusicCatalogController {

    @RequestMapping(method= RequestMethod.GET, path="/")
    public String home(Model model){
        return "music_catalog";
    }
}
