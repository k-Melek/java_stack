package com.melek.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.melek.lookify.models.Song;
import com.melek.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {

	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	// View route for List of songs
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", songService.findAll());
		return "dashboard.jsp";
	}
	
	// View One Song
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songService.findSong(id));
		return "showSong.jsp";
	}
	
	// View search
	@PostMapping("/dashboard")
	public String dashboard(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		return "redirect:/search"+artist;
	}
	
	// Action Search result
	@GetMapping("/search/{artist}")
	public String searchResult(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("songs", songService.findByArtist(artist));
		model.addAttribute("searchWord", artist);
		return "searchResult.jsp";
	}
	
	// View route create
	@GetMapping("/songs/new")
	public String createSong(@ModelAttribute("song") Song song) {
		return "createSong.jsp";
	}
	// Action route create
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "createSong.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	// DELETE METHOD
    @DeleteMapping(value="/songs/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/search/topTen")
    public String topTenSongs(Model model) {
    	List<Song> topTen = songService.findTopTen();
    	model.addAttribute("topTen", topTen);
    	return "topTen.jsp";
    }
			
}
