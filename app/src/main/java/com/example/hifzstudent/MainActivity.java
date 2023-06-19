package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add, view, git, rec;

        add = findViewById(R.id.button);
        view = findViewById(R.id.button2);
        git = findViewById(R.id.button3);
        rec = findViewById(R.id.button5);

        // Move to Activity 2
        Intent activity2Intent = new Intent(this, MainActivity2.class);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(activity2Intent);
            }
        });

        // Read
        Intent read = new Intent(this, MainActivity3.class);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(read);
            }
        });

        String websiteUrl = "https://github.com/Rohaan-Arshad/HifzStudent";
        Intent gitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));

        // GitHub button
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gitIntent);
            }
        });

        // Move to Activity 5
        Intent activity5Intent = new Intent(this, MainActivity5.class);
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(activity5Intent);
            }
        });

    }
}
