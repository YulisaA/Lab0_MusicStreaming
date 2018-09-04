package com.example.dell.lab0_musicstreaming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.HashMap;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mySongs;
    private PlaylistProperties playList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySongs = (ListView) findViewById(R.id.mySongs);
        playList = new PlaylistProperties(this, getItems());
        mySongs.setAdapter(playList);
    }
    private ArrayList<Song> getItems()
    {
        ArrayList<Song> list = new ArrayList<>();

        list.add(new Song(R.drawable.music, "Be the One", "3:04"));
        list.add(new Song(R.drawable.music, "Empires", "4:30"));
        list.add(new Song(R.drawable.music, "Closer", "5:01"));
        list.add(new Song(R.drawable.music, "From The Inside Out", "4:03"));
        list.add(new Song(R.drawable.music, "Your love is a song", "3:51"));
        list.add(new Song(R.drawable.music, "Back To Life", "2:40"));
        list.add(new Song(R.drawable.music, "La otra orilla", "1:20"));
        list.add(new Song(R.drawable.music, "Heartbeats", "5:11"));
        list.add(new Song(R.drawable.music, "Closer than you know", "3:03"));
        list.add(new Song(R.drawable.music, "Every Little Thing", "4:50"));

        return list;
    }

    private HashMap<String, Song> searchItem()
    {
        HashMap<String, Song> dictionary = new HashMap<>();

        dictionary.put("Be the One", new Song(R.drawable.music, "Be the One", "3:04"));
        dictionary.put("Empires", new Song(R.drawable.music, "Empires", "4:30"));
        dictionary.put("Closer", new Song(R.drawable.music, "Closer", "5:01"));
        dictionary.put("From The Inside Out", new Song(R.drawable.music, "From The Inside Out", "4:03"));
        dictionary.put("Your love is a song", new Song(R.drawable.music, "Your love is a song", "3:51"));
        dictionary.put("Back To Life", new Song(R.drawable.music, "Back To Life", "2:40"));
        dictionary.put("La otra orilla", new Song(R.drawable.music, "La otra orilla", "1:20"));
        dictionary.put("Heartbeats", new Song(R.drawable.music, "Heartbeats", "5:11"));
        dictionary.put("Closer than you know", new Song(R.drawable.music, "Closer than you know", "3:03"));
        dictionary.put("Every Little Thing", new Song(R.drawable.music, "Every Little Thing", "4:50"));

        return dictionary;
    }


}
