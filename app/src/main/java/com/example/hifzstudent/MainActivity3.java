package com.example.hifzstudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    SearchView search;
    ArrayList<Student> dataHolder;
    RecyclerView rc;
    AdapterRecycler ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rc = findViewById(R.id.recycler);
        search = findViewById(R.id.searchView);
        search.setIconifiedByDefault(false);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        search.setFocusable(true);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(search, InputMethodManager.SHOW_IMPLICIT);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }
        });

        rc.setLayoutManager(new LinearLayoutManager(this));

        DBHelper dr = new DBHelper(this);
        dataHolder = dr.getAllStudents();

        ad = new AdapterRecycler(dataHolder, getApplicationContext());
        rc.setAdapter(ad);
    }

    public void filterList(String text) {
        ArrayList<Student> filteredList = new ArrayList<>();
        for (Student student : dataHolder) {
            if (student.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(student);
            }
        }
        if (filteredList.isEmpty()) {
            ad.setFilterList(filteredList);
            Toast.makeText(this, "No data Found!", Toast.LENGTH_SHORT).show();
        } else {
            ad.setFilterList(filteredList);
        }
    }
}
