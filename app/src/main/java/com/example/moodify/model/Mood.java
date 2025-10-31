package com.example.moodify.model;

public class Mood {
    private String name;
    private String quote;
    private String playlistUrl;
    private int imageResId;

    public Mood(String name, String quote, String playlistUrl, int imageResId) {
        this.name = name;
        this.quote = quote;
        this.playlistUrl = playlistUrl;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getQuote() { return quote; }
    public String getPlaylistUrl() { return playlistUrl; }
    public int getImageResId() { return imageResId; }
}
