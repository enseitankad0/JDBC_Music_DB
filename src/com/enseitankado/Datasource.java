package com.enseitankado;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {


    public static final String DB_NAME = "music.db";





    public static final String CONNECTION_STRING =
            "jdbc:sqlite:D:\\Dropbox\\PathToDatabase\\" + DB_NAME;

    public static final String QUERY_SONGS_FROM_SPECIFIED_ARTIST =

            "SELECT songs.title, albums.name, artists.name, songs.track" +
                    " FROM songs" +
                    " INNER JOIN albums ON songs.album = albums._id" +
                    " INNER JOIN artists ON artists._id = albums.artist" +
                    " WHERE artists.name " + " = ? " +
                    " ORDER BY albums.name, songs.track;";

    public static final String FIND_ARTIST_FOR_SONG =

            "SELECT songs.title, albums.name, artists.name, songs.track" +
                    " FROM songs" +
                    " INNER JOIN albums ON songs.album = albums._id" +
                    " INNER JOIN artists ON artists._id = albums.artist" +
                    " WHERE songs.title " + " = ? " +
                    " ORDER BY albums.name, songs.track;";


    private PreparedStatement querySongInfoView;
    private PreparedStatement findAritstForSpecifiedSong;
    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_SONGS_FROM_SPECIFIED_ARTIST);
           findAritstForSpecifiedSong = conn.prepareStatement(FIND_ARTIST_FOR_SONG);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Song> queryEverything(String artistToQuery) {

        //System.out.println("SQL Statement: " + QUERY_SONGS_FROM_SPECIFIED_ARTIST);

        try {
            querySongInfoView.setString(1, artistToQuery);
            ResultSet results = querySongInfoView.executeQuery();

            List<Song> songList = new ArrayList<>();

            while (results.next()) {
                Song song = new Song();

                song.setSongName(results.getString(1));
                song.setAlbumName(results.getString(2));
                song.setArtistName(results.getString(3));
                song.setTrackNumber(results.getInt(4));


                songList.add(song);

            }


            printResult(songList);
            return songList;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Song> findAristForSong(String songTitle) {

       // System.out.println("SQL Statement: " + FIND_ARTIST_FOR_SONG);

        try {

            findAritstForSpecifiedSong.setString(1, songTitle);
            ResultSet results = findAritstForSpecifiedSong.executeQuery();

            List<Song> songList = new ArrayList<>();

            while (results.next()){

            Song song = new Song();

            song.setSongName(results.getString(1));
            song.setAlbumName(results.getString(2));
            song.setArtistName(results.getString(3));
            song.setTrackNumber(results.getInt(4));


            songList.add(song);


        }

           printResult(songList);
            return songList;


        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }


    }



    public static void printResult(List<Song> songs) {


        if(
                !songs.isEmpty()){

            System.out.println("Results");
            System.out.println(String.format("|%1$-5s|%2$-30s|%3$-30s|%4$-30s", "Track", "Song title", "Album name", "Artist name"));
            System.out.println("---------------------------------------------------------------------------------------------------");



            for(Song song : songs){
                int trackNumber = song.getTrackNumber();
                String songName = song.getSongName();
                String albumName = song.getAlbumName();
                String artistName = song.getArtistName();

                System.out.println(String.format("|%1$-5s|%2$-30s|%3$-30s|%4$-30s",trackNumber,songName,albumName,artistName));

            }
        } else {
            System.out.println("Query is empty. Artist/song not found");
        }


    }


}







