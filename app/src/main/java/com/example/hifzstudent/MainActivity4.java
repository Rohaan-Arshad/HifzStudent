package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        TextView na,rol,set;
        Intent ne = getIntent();
        String roll=ne.getStringExtra("rol");
        String name = ne.getStringExtra("nam");

        na=findViewById(R.id.textView3);
        rol=findViewById(R.id.textView2);
        set=findViewById(R.id.textView4);

        rol.setText(roll);
        na.setText(name);

        ArrayList<Record> rec;
        DBHelper re = new DBHelper(this);
        rec=re.getRecords(roll);

        StringBuilder stringBuilder = new StringBuilder();
        for (Record record : rec) {
            stringBuilder.append("Date: ").append(record.getDate()).append("\n");
            stringBuilder.append("Sabaq Surah: ").append(record.getSabaq_surah()).append("\n");
            stringBuilder.append("Sabaq Ayat: ").append(record.getSabaq_ayat()).append("\n");
            stringBuilder.append("Sabaq Parah: ").append(record.getSabaq_parah()).append("\n");
            stringBuilder.append("Sabqi Parah: ").append(record.getSabqi_parah()).append("\n");
            stringBuilder.append("Manzil Parah: ").append(record.getManzil_parah()).append("\n");
            stringBuilder.append("----------------------------------------").append("\n"); // Add a line separator
        }

        set.setText(stringBuilder.toString());

    }
}