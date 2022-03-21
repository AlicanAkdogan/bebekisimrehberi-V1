package com.alican.bebeksimrehberi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NamesDao {

    public ArrayList<Names> tumİsimler(Database vt){
        ArrayList<Names> modelArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM babynames",null);

        while (c.moveToNext()){
            Names m1 = new Names(c.getInt(c.getColumnIndex("name_id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("name_explanation"))
            );

            modelArrayList.add(m1);

        }

        return modelArrayList;
    }

    public ArrayList<Names> kelimeAra(Database vt,String aramaKelime){

        ArrayList<Names> modelArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM babynames WHERE name like '%"+aramaKelime+"%'",null);

        while (c.moveToNext()){
            Names m1 = new Names(c.getInt(c.getColumnIndex("name_id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("name_explanation"))
            );

            modelArrayList.add(m1);

        }

        return modelArrayList;
    }


}
