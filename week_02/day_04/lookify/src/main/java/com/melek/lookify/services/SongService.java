package com.melek.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.lookify.models.Song;
import com.melek.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo;

	// READ ALL
	public List<Song> findAll() {
		return songRepo.findAll();
	}

	// CREATE
	public Song createSong(Song b) {
		return songRepo.save(b);
	}

	// READ ONE
	public Song findSong(Long id) {
		Optional<Song> maybeSong = songRepo.findById(id);
		if (maybeSong.isPresent()) {
			return maybeSong.get();
		} else {
			return null;
		}
	}

	// Find songs by artist
	public List<Song> findByArtist(String artist) {
		return songRepo.findByArtistIgnoreCase(artist);
	}
	
	// List of top 10
	public List<Song> findTopTen(){
		return songRepo.findTop10ByOrderByRatingDesc();
	}

	// DELETE
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}

	
}
