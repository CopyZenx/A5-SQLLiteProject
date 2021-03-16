package com.musayilmaz.sqlliteproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.security.cert.CRLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INT)" );

            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('James', 50)");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('Lars', 60)");
            //database.execSQL("INSERT INTO musicians (name, age) VALUES ('Kirk', 40)");

            //database.execSQL("UPDATE musicians SET age = 61 where name ='Lars' ");
            //database.execSQL("UPDATE musicians SET name = 'Kirk Hammit' where id = 3 ");

            //database.execSQL("DELETE FROM musicians WHERE id = 2 ");

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'James'", null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE age >= 50", null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 'K%'", null);
            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'", null);
            Cursor cursor = database.rawQuery("SELECT * FROM musicians", null);


            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIX = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIx));
                System.out.println("id: " + cursor.getInt(idIX));


            }

            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
