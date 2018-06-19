package com.enseitankado;

public class Song {

    public String songName;
    public String albumName;
    public String artistName;
    public int trackNumber;

    public Song() {
        this.songName = songName;
        this.albumName = albumName;
        this.artistName = artistName;
        this.trackNumber = trackNumber;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public String toString() {
        return songName + " / " + albumName  + " / " + artistName  + " / " + trackNumber +"\n";
    }
}
