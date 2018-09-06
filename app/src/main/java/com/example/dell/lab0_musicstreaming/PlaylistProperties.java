package com.example.dell.lab0_musicstreaming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistProperties extends BaseAdapter{

    private Context context;
    private ArrayList<Song> Playlist;
    private String name;

    @Override
    public int getCount() {
        return Playlist.size();
    }

    public PlaylistProperties(String name, Context context, ArrayList<Song> playlist) {
        this.name = name;
        this.context = context;
        Playlist = playlist;
    }

    @Override

    public Object getItem(int position) {
        return Playlist.get(position);
    }

    @Override
    public long getItemId(int position) {


        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song Item = (Song) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.playlist_show,  null);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtDuration = (TextView) convertView.findViewById(R.id.txtDuration);

        imgView.setImageResource(Item.getIcon());
        txtName.setText(Item.getName());
        txtDuration.setText(Item.getDuration());

        return convertView;
    }

    public String getName(){return name;}
    public ArrayList<Song> getPlaylist() {return Playlist;}
}
