package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText roll,name,age,cla;

        Button b;
        roll = findViewById(R.id.editTextTextMultiLine123);
        name = findViewById(R.id.editTextTextMultiLine2);
        age = findViewById(R.id.editTextTextMultiLine3);
        cla = findViewById(R.id.editTextTextMultiLine4);

        b=findViewById(R.id.button45);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(roll.getText().toString()) ||
                        TextUtils.isEmpty(name.getText().toString()) ||
                        TextUtils.isEmpty(age.getText().toString()) ||
                        TextUtils.isEmpty(cla.getText().toString())
                       ) {
                    Toast.makeText(MainActivity2.this, "Enter all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dt = new DBHelper(MainActivity2.this);

                    Student st = new Student(roll.getText().toString(), name.getText().toString(), Integer.parseInt(age.getText().toString()), cla.getText().toString());

                    if (dt.isIdExists(roll.getText().toString())) {
                        Toast.makeText(MainActivity2.this, "ID already EXsists", Toast.LENGTH_SHORT).show();
                    } else {
                        int i = dt.insertStudent_tab(st);
                        if (i == 1) {
                            Toast.makeText(MainActivity2.this, "Student Inserted!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }
}