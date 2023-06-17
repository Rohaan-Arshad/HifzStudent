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

        Button add, view,git;

        add= findViewById(R.id.button);
        view= findViewById(R.id.button2);
        git= findViewById(R.id.button3);

        // write
        Intent i = new Intent(this,MainActivity2.class);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });

        // read
        Intent read = new Intent(this,MainActivity3.class);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(read);
            }
        });

        String websiteUrl = "https://github.com/Rohaan-Arshad/HifzStudent";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
        //  git code
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}