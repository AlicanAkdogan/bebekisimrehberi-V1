package com.alican.bebeksimrehberi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView mainRv;

    private ArrayList<Names> namesArrayList;
    private NamesAdapter adapter;
    private Database vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        mainRv = findViewById(R.id.mainRv);

        toolbar.setTitle("Popüler Bebek İsimleri");
        setSupportActionBar(toolbar);

        vt = new Database(this);
        veritabaniKopyala();

        mainRv.setHasFixedSize(true);
        mainRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        /*
        namesArrayList = new ArrayList<>();
        namesArrayList.add(new Names(1,"BESTENİGAR","test açıklama"));
        namesArrayList.add(new Names(2,"testgfdgdfg","test açıklama"));
        namesArrayList.add(new Names(3,"testgfdg","test açıklama"));
        namesArrayList.add(new Names(4,"testgfdgd","test açıklama"));
        namesArrayList.add(new Names(5,"tesgfdgdft","test açıklama"));
        namesArrayList.add(new Names(6,"tesgfdgdt","test açıklama"));
        namesArrayList.add(new Names(7,"tesgfdgdfgdfgt","test açıklama"));
        namesArrayList.add(new Names(8,"tesgfdgdfgdt","test açıklama"));
        namesArrayList.add(new Names(9,"tesdfgdfgdfgdfgdft","test açıklama"));
         */

        namesArrayList = new NamesDao().tumİsimler(vt);

        adapter = new NamesAdapter(this,namesArrayList);
        mainRv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_search,menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        Log.e("Gönderilen Arama",query);
        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        Log.e("Harf Girdikçe",newText);
        aramaYap(newText);
        return false;
    }

    public void veritabaniKopyala(){

        DatabaseCopyHelper databaseCopyHelper = new DatabaseCopyHelper(this);
        try {
            databaseCopyHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseCopyHelper.openDataBase();

    }

    public void aramaYap(String aramaKelime){

        namesArrayList = new NamesDao().kelimeAra(vt,aramaKelime);

        adapter = new NamesAdapter(this,namesArrayList);
        mainRv.setAdapter(adapter);

    }
}





























