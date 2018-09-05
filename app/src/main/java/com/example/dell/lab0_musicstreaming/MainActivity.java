package com.example.dell.lab0_musicstreaming;

import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.txtSearch)
    EditText txtSearch;
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.mySongs)
    ListView mySongs;
    @BindView(R.id.guideline2)
    Guideline guideline2;
    //private ListView mySongs;

    private PlaylistProperties playList;
    private PlaylistProperties playListSearch;
    HashMap<String, Song> dictionary = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mySongs = (ListView) findViewById(R.id.mySongs);
        playList = new PlaylistProperties(this, getItems());
        mySongs.setAdapter(playList);
    }

    private ArrayList<Song> getItems() {
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

    private ArrayList<Song> getItemsSearch() {
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
        searchItem();

        return list;
    }

    public HashMap<String, Song> searchItem() {

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


    @OnClick(R.id.btnSearch)
    public void onViewClicked() {
        if(txtSearch.getText().length() == 0)
        {
            Toast.makeText (this,"Ingrese canción",Toast.LENGTH_SHORT).show();
        }
        else{
            String key = txtSearch.getText().toString();
             if(searchItem().containsKey(key))
             {
                 ArrayList<Song> tempList = new ArrayList<>();
                 tempList.add(new Song(R.drawable.music, key, dictionary.get(key).getDuration().toString()));
                 mySongs = (ListView) findViewById(R.id.mySongs);
                 playListSearch = new PlaylistProperties(this, tempList);
                 mySongs.setAdapter(playListSearch);
             }
             else{
                 Toast.makeText (this,"No se encuentra la canción.",Toast.LENGTH_LONG).show();
             }
        }
    }
}
