package com.example.ss8_song.service;

import com.example.ss8_song.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    List<Song> songList = new ArrayList<>();

    public void addSong(Song song) {
        songList.add(song);
    }
    public List<Song> findAll() {
        return songList;
    }
    public void updateSong(Song song, int index) {
        songList.set(index, song);
    }
    public void deleteSong(int index) {
        songList.remove(index);
    }
    public Song findSongById(int index) {
        return songList.get(index);
    }
}
