package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proteintracker.Adapter.MahasiswaAdapter;
import com.example.proteintracker.Model.Mahasiswa;

import java.util.ArrayList;

public class InClassRecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_class_recycler);

        addData();

        recyclerView = findViewById(R.id.rvInClass);
        mahasiswaAdapter = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InClassRecyclerActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mahasiswaAdapter);
    }

    private void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Eben Haezer G","72160071","081273724898"));
        /*​mahasiswaArrayList.add(new Mahasiswa("Libra Dohko","71160089","02188795"));*/
        mahasiswaArrayList.add(new Mahasiswa("Aries Mu","123456887","098758124"));
        mahasiswaArrayList.add(new Mahasiswa("Gemini Saga","1414370309","123456789"));
    }
    }

