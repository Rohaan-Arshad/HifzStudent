package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ArrayList<Student>dataHolder ;

        RecyclerView rc;

        rc=findViewById(R.id.recycler);
        rc.setLayoutManager(new LinearLayoutManager(this));


        DBHelper dr =  new DBHelper(this);
        dataHolder = dr.getAllStudents();


    }
}