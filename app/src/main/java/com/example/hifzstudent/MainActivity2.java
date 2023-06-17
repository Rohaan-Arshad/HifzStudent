package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText roll,name,age,cla,sabaq_surah,sabaq_ayat,sabaq_parah,sabqi_parah,manzil_parah,date;
        Button b;
        roll = findViewById(R.id.editTextTextMultiLine);
        name = findViewById(R.id.editTextTextMultiLine2);
        age = findViewById(R.id.editTextTextMultiLine3);
        cla = findViewById(R.id.editTextTextMultiLine4);

        sabaq_surah = findViewById(R.id.editTextTextMultiLine5);
        sabaq_ayat = findViewById(R.id.editTextTextMultiLine6);
        sabaq_parah = findViewById(R.id.editTextTextMultiLine7);
        sabqi_parah = findViewById(R.id.editTextTextMultiLine8);
        manzil_parah = findViewById(R.id.editTextTextMultiLine9);
        date = findViewById(R.id.editTextTextMultiLine10);
        b=findViewById(R.id.button4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dt = new DBHelper(MainActivity2.this);
                Student st = new Student(roll.getText().toString(),name.getText().toString(),Integer.parseInt(age.getText().toString()),cla.getText().toString());

                Record re = new Record(roll.getText().toString(),sabaq_surah.getText().toString(),Integer.parseInt(sabaq_ayat.getText().toString()),Integer.parseInt(sabaq_parah.getText().toString()),Integer.parseInt(sabqi_parah.getText().toString()),Integer.parseInt(manzil_parah.getText().toString()),date.getText().toString());

                if (dt.isIdExists(roll.getText().toString())) {
                    dt.insertRecord_ID(re);
                    Toast.makeText(MainActivity2.this, "Student Record Appended !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int i = dt.insertStudent(st,re);
                    if(i==1)
                    {
                        Toast.makeText(MainActivity2.this, "Student Inserted !", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}