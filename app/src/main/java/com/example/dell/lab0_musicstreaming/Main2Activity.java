package com.example.dell.lab0_musicstreaming;

import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
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
    private PlaylistProperties List;
    HashMap<String, Song> dictionary = new HashMap<>();
    ArrayList<Song> list = new ArrayList<>();
    ArrayList<playList> ListOfLists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btnAdd, R.id.btnCreate, R.id.btnSort, R.id.btnCreatePL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                break;
            case R.id.btnCreate:
                txtNamePL.setVisibility(View.VISIBLE);
                btnCreatePL.setVisibility(View.VISIBLE);
                break;
            case R.id.btnSort:
                break;
            case R.id.btnCreatePL:
                ArrayList<Song> tempList = new ArrayList<>();
                tempList.add(new Song(R.drawable.noth, "", ""));
                mySongs = (ListView) findViewById(R.id.mySongs);
                List = new PlaylistProperties(this, tempList);
                mySongs.setAdapter(List);

                String name = txtNamePL.getText().toString();
                playList myplaylist;
                myplaylist = new playList(name, tempList);

                if (ListOfLists.contains(myplaylist)) {
                    Toast.makeText(this, "Ingrese otro nombre.", Toast.LENGTH_LONG).show();
                } else {
                    ListOfLists.add(myplaylist);

                    Spinner spinner = (Spinner) findViewById(R.id.spinner);
                    String[] names = new String[ListOfLists.size()];

                    for(int i = 0; i < names.length; i++) {
                        names[i] = ListOfLists.get(i).getName();
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_spinner_item, names);
                    spinner.setAdapter(adapter);
                }
                break;
        }
    }




}
