package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent ne = getIntent();
        String roll=ne.getStringExtra("rol");
        String name = ne.getStringExtra("nam");

    }
}