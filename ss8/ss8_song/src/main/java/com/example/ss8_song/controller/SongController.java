package com.example.ss8_song.controller;

import com.example.ss8_song.model.Song;
import com.example.ss8_song.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.addSong(song);
        return "redirect:/song";
    }

    @GetMapping("/edit/{index}")
    public String showEditForm(@PathVariable int index, Model model) {
        model.addAttribute("song", songService.findSongById(index));
        model.addAttribute("index", index);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam int index, @Valid @ModelAttribute("song") Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        songService.updateSong(song, index);
        return "redirect:/song";
    }
}
