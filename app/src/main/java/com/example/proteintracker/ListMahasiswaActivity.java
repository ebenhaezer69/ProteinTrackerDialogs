package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class ListMahasiswaActivity extends AppCompatActivity {
    String[] items ={"Harold", "Erick", "Aru", "Brian", "Ryan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        ListView listView = findViewById(R.id.lvMhs);
        Spinner spinner = findViewById(R.id.mhsSpinner);

        listView.setAdapter(new ArrayAdapter<String>(ListMahasiswaActivity.this, android.R.layout.simple_list_item_1,items));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListMahasiswaActivity.this, android.R.layout.simple_spinner_item,items);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda memilih = " + items [i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda tidak memilih", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda memilih = " +  items [i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void GoToCreate(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, CreateMhsActivity.class);
        startActivity(intent);
    }

    public void GoToUpdate(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, UpdateMhsActivity.class);
        startActivity(intent);
    }
}
