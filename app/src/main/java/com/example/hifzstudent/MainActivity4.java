package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        TextView na,rol;
        Intent ne = getIntent();
        String roll=ne.getStringExtra("rol");
        String name = ne.getStringExtra("nam");

        na=findViewById(R.id.textView3);
        rol=findViewById(R.id.textView2);

        rol.setText(roll);
        na.setText(name);

        DBHelper re = new DBHelper(this);
        re.getRecords(roll);




    }
}