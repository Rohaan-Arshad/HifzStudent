package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText roll,name,age,cla,surah,ayat,parah;

        roll = findViewById(R.id.editTextTextMultiLine);
        name = findViewById(R.id.editTextTextMultiLine2);
        age = findViewById(R.id.editTextTextMultiLine3);
        cla = findViewById(R.id.editTextTextMultiLine4);
        parah = findViewById(R.id.editTextTextMultiLine5);
        surah = findViewById(R.id.editTextTextMultiLine6);
        ayat = findViewById(R.id.editTextTextMultiLine7);



    }
}