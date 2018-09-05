package com.example.dell.lab0_musicstreaming;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class playList {

    private String tittle;
    private ArrayList<Song> Playlist;

    public playList(String tittle, ArrayList<Song> tempList)
    {
        this.tittle = tittle;
        this.Playlist = Playlist;
    }
    public String getName(){return tittle;}
    public ArrayList<Song> getPlaylist() {return Playlist;}
}
