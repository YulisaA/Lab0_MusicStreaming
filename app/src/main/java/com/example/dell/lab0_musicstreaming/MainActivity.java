package com.example.dell.lab0_musicstreaming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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

        list.add(new Song(R.drawable.music, "Prueba", "3:04"));
        list.add(new Song(R.drawable.music, "Prueba2", "4:00"));
        list.add(new Song(R.drawable.music, "ysong", "4:00"));
        list.add(new Song(R.drawable.music, "son2", "4:03"));
        list.add(new Song(R.drawable.music, "song3", "4:00"));
        list.add(new Song(R.drawable.music, "song4", "4:00"));
        list.add(new Song(R.drawable.music, "son5", "4:00"));
        list.add(new Song(R.drawable.music, "song6", "4:00"));
        list.add(new Song(R.drawable.music, "song7", "4:00"));
        list.add(new Song(R.drawable.music, "song8", "4:00"));



        return list;
    }


}
