package com.example.dell.lab0_musicstreaming;

public class Song {
    private int icon;
    private String name;
    private String duration;

    public Song(int icon, String name, String duration)
    {
        this.icon = icon;
        this.name = name;
        this.duration = duration;
    }

    public int getIcon(){return icon;}
    public String getName(){return name;}
    public String getDuration(){return duration;}
}
