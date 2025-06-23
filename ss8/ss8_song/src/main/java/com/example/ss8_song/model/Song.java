package com.example.ss8_song.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Song {

    @NotBlank(message = "Song's name cannot be left empty")
    @Size(max = 800, message = "Song's name too long")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols")
    private String name;

    @NotBlank(message = "Artist's name cannot be left empty")
    @Size(max = 300, message = "Artist's name too long")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols")
    private String artist;

    @NotBlank(message = "Genre cannot be left empty")
    @Size(max = 1000, message = "Genre too long")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols")
    private String genre;

    public @NotBlank(message = "Song's name cannot be left empty") @Size(max = 800, message = "Song's name too long") @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Song's name cannot be left empty") @Size(max = 800, message = "Song's name too long") @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Artist's name cannot be left empty") @Size(max = 300, message = "Artist's name too long") @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols") String getArtist() {
        return artist;
    }

    public void setArtist(@NotBlank(message = "Artist's name cannot be left empty") @Size(max = 300, message = "Artist's name too long") @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols") String artist) {
        this.artist = artist;
    }

    public @NotBlank(message = "Genre cannot be left empty") @Size(max = 1000, message = "Genre too long") @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols") String getGenre() {
        return genre;
    }

    public void setGenre(@NotBlank(message = "Genre cannot be left empty") @Size(max = 1000, message = "Genre too long") @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Cannot contain special symbols") String genre) {
        this.genre = genre;
    }
}
