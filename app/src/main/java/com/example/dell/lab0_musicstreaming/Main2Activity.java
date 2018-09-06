package com.example.dell.lab0_musicstreaming;

import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {


    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnCreate)
    Button btnCreate;
    @BindView(R.id.btnSort)
    Button btnSort;
    @BindView(R.id.guideline4)
    Guideline guideline4;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.mySongs)
    ListView mySongs;
    @BindView(R.id.guideline2)
    Guideline guideline2;
    @BindView(R.id.txtNamePL)
    EditText txtNamePL;
    @BindView(R.id.btnCreatePL)
    Button btnCreatePL;
    @BindView(R.id.btnAddSong)
    Button btnAddSong;
    @BindView(R.id.txtDSong)
    EditText txtDSong;
    @BindView(R.id.txtNameSong)
    EditText txtNameSong;
    @BindView(R.id.rbASC)
    RadioButton rbASC;
    @BindView(R.id.rbDESC)
    RadioButton rbDESC;
    @BindView(R.id.btnSortPL)
    Button btnSortPL;

    private PlaylistProperties myplaylist;
    HashMap<String, Song> dictionary = new HashMap<>();
    ArrayList<Song> list = new ArrayList<>();
    ArrayList<PlaylistProperties> ListOfLists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnAdd, R.id.btnCreate, R.id.btnSort, R.id.btnCreatePL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //Add a new song to one of the playlists created
            case R.id.btnAdd:
                txtNamePL.setVisibility(View.INVISIBLE);
                btnCreatePL.setVisibility(View.INVISIBLE);
                txtNameSong.setVisibility(View.VISIBLE);
                txtDSong.setVisibility(View.VISIBLE);
                btnAddSong.setVisibility(View.VISIBLE);
                btnSortPL.setVisibility(View.INVISIBLE);

                rbASC.setVisibility(View.INVISIBLE);
                rbDESC.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnCreate:
                txtNamePL.setVisibility(View.VISIBLE);
                btnCreatePL.setVisibility(View.VISIBLE);
                txtNameSong.setVisibility(View.INVISIBLE);
                txtDSong.setVisibility(View.INVISIBLE);
                btnAddSong.setVisibility(View.INVISIBLE);
                btnSortPL.setVisibility(View.INVISIBLE);
;
                rbASC.setVisibility(View.INVISIBLE);
                rbDESC.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnSort:
                txtNamePL.setVisibility(View.INVISIBLE);
                btnCreatePL.setVisibility(View.INVISIBLE);
                txtNameSong.setVisibility(View.INVISIBLE);
                txtDSong.setVisibility(View.INVISIBLE);
                btnAddSong.setVisibility(View.INVISIBLE);
                btnSortPL.setVisibility(View.VISIBLE);

                rbASC.setVisibility(View.VISIBLE);
                rbDESC.setVisibility(View.VISIBLE);
                break;
            case R.id.btnCreatePL:
                ArrayList<Song> tempList = new ArrayList<>();
                tempList.add(new Song(R.drawable.noth, "", ""));
                mySongs = (ListView) findViewById(R.id.mySongs);
                myplaylist = new PlaylistProperties("", this, tempList);
                mySongs.setAdapter(myplaylist);

                String name = txtNamePL.getText().toString();
                myplaylist = new PlaylistProperties(name, this, tempList);

                if (ListOfLists.contains(myplaylist)) {
                    Toast.makeText(this, "Ingrese otro nombre.", Toast.LENGTH_LONG).show();
                } else {
                    ListOfLists.add(myplaylist);

                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    String[] names = new String[ListOfLists.size()];

                    for (int i = 0; i < names.length; i++) {
                        names[i] = ListOfLists.get(i).getName();
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item, names);
                    spinner.setAdapter(adapter);
                }
                txtNamePL.setVisibility(View.INVISIBLE);
                btnCreatePL.setVisibility(View.INVISIBLE);
                txtNameSong.setVisibility(View.INVISIBLE);
                txtDSong.setVisibility(View.INVISIBLE);
                btnAddSong.setVisibility(View.INVISIBLE);
                btnSortPL.setVisibility(View.INVISIBLE);

                rbASC.setVisibility(View.INVISIBLE);
                rbDESC.setVisibility(View.INVISIBLE);
                break;
        }
    }


    @OnClick(R.id.btnAddSong)
    public void onViewClicked() {
        txtNamePL.setVisibility(View.INVISIBLE);
        btnCreatePL.setVisibility(View.INVISIBLE);
        txtNameSong.setVisibility(View.INVISIBLE);
        txtDSong.setVisibility(View.INVISIBLE);
        btnAddSong.setVisibility(View.INVISIBLE);
        btnSortPL.setVisibility(View.INVISIBLE);

        rbASC.setVisibility(View.INVISIBLE);
        rbDESC.setVisibility(View.INVISIBLE);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String namePlaylist = mySpinner.getSelectedItem().toString();
        String nameSong = txtNameSong.getText().toString();
        String durationSong = txtDSong.getText().toString();

        for (int i = 0; i < ListOfLists.size(); i++) {
            if (namePlaylist == ListOfLists.get(i).getName()) {
                ListOfLists.get(i).getPlaylist().add(new Song(R.drawable.music, nameSong, durationSong));

                mySongs = (ListView) findViewById(R.id.mySongs);
                myplaylist = new PlaylistProperties(namePlaylist, this, ListOfLists.get(i).getPlaylist());
                mySongs.setAdapter(myplaylist);
            }
        }


    }

    @OnClick(R.id.btnSortPL)
    public void onViewClickedd() {
        txtNamePL.setVisibility(View.INVISIBLE);
        btnCreatePL.setVisibility(View.INVISIBLE);
        txtNameSong.setVisibility(View.INVISIBLE);
        txtDSong.setVisibility(View.INVISIBLE);
        btnAddSong.setVisibility(View.INVISIBLE);
        btnSortPL.setVisibility(View.INVISIBLE);

        rbASC.setVisibility(View.INVISIBLE);
        rbDESC.setVisibility(View.INVISIBLE);

        RadioButton rb1ASC = (RadioButton) findViewById(R.id.rbASC);
        RadioButton rb2DESC = (RadioButton) findViewById(R.id.rbDESC);

        if(rb1ASC.isChecked())
        {
            Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
            String namePlaylist = mySpinner.getSelectedItem().toString();

            for (int i = 0; i < ListOfLists.size(); i++) {
                if (namePlaylist == ListOfLists.get(i).getName()) {
                    Collections.sort(ListOfLists.get(i).getPlaylist(), new Comparator<Song>() {

                        public int compare(Song t1, Song t2) {
                            return t1.getName().compareTo(t2.getName());
                        }
                    });

                    mySongs = (ListView) findViewById(R.id.mySongs);
                    myplaylist = new PlaylistProperties(namePlaylist, this, ListOfLists.get(i).getPlaylist());
                    mySongs.setAdapter(myplaylist);
                }
            }
        }
        else if(rb2DESC.isChecked())
        {
            Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
            String namePlaylist = mySpinner.getSelectedItem().toString();

            for (int i = 0; i < ListOfLists.size(); i++) {
                if (namePlaylist == ListOfLists.get(i).getName()) {
                    Collections.sort(ListOfLists.get(i).getPlaylist(), new Comparator<Song>() {

                        public int compare(Song t1, Song t2) {
                            return t1.getDuration().compareTo(t2.getDuration());
                        }
                    });

                    mySongs = (ListView) findViewById(R.id.mySongs);
                    myplaylist = new PlaylistProperties(namePlaylist, this, ListOfLists.get(i).getPlaylist());
                    mySongs.setAdapter(myplaylist);
                }
            }

        }
        else{
            Toast.makeText(this, "Seleccione una de las opciones.", Toast.LENGTH_LONG).show();
        }

    }
}
