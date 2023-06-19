package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        EditText roll,sabaq_surah,sabaq_ayat,sabaq_parah,sabqi_parah,manzil_parah,date;

        Button b;
        roll = findViewById(R.id.editTextTextMultiLine123);

        sabaq_surah = findViewById(R.id.editTextTextMultiLine5);
        sabaq_ayat = findViewById(R.id.editTextTextMultiLine6);
        sabaq_parah = findViewById(R.id.editTextTextMultiLine7);
        sabqi_parah = findViewById(R.id.editTextTextMultiLine8);
        manzil_parah = findViewById(R.id.editTextTextMultiLine9);
        date = findViewById(R.id.editTextTextMultiLine10);
        b=findViewById(R.id.button45);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(roll.getText().toString()) ||
                        TextUtils.isEmpty(sabaq_surah.getText().toString()) ||
                        TextUtils.isEmpty(sabaq_ayat.getText().toString()) ||
                        TextUtils.isEmpty(sabaq_parah.getText().toString()) ||
                        TextUtils.isEmpty(sabqi_parah.getText().toString()) ||
                        TextUtils.isEmpty(manzil_parah.getText().toString()) ||TextUtils.isEmpty(date.getText().toString())
                ) {
                    Toast.makeText(MainActivity5.this, "Enter all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dt = new DBHelper(MainActivity5.this);

                    //Student st = new Student(roll.getText().toString(), name.getText().toString(), Integer.parseInt(age.getText().toString()), cla.getText().toString());
                    Record re = new Record(roll.getText().toString(), sabaq_surah.getText().toString(), Integer.parseInt(sabaq_parah.getText().toString()), sabaq_ayat.getText().toString(), Integer.parseInt(sabqi_parah.getText().toString()), Integer.parseInt(manzil_parah.getText().toString()), date.getText().toString());

                    if (dt.isIdExists(roll.getText().toString())) {
                        int i = dt.insertRecord_ID(re);
                        if (i == 1) {
                            Toast.makeText(MainActivity5.this, "Daily task added !", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity5.this, "Please Add Student !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}