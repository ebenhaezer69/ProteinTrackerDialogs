package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proteintracker.Adapter.DataMhsAdapter;
import com.example.proteintracker.Adapter.MahasiswaAdapter;
import com.example.proteintracker.Model.DataMhs;
import com.example.proteintracker.Model.Mahasiswa;

import java.util.ArrayList;

public class ListMahasiswaActivity extends AppCompatActivity {
    private DataMhsAdapter dataMhsAdapter;
    private ArrayList<DataMhs> dataMhsArrayList;
    private RecyclerView recyclerView;

    String[] items ={"Harold", "Erick", "Aru", "Brian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        /*ListView listView = findViewById(R.id.lvMhs);*/
        Spinner spinner = findViewById(R.id.mhsSpinner);

        addData();


        recyclerView = findViewById(R.id.rcDataMhs);
        dataMhsAdapter = new DataMhsAdapter(dataMhsArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListMahasiswaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataMhsAdapter);

        /*recyclerView.setAdapter(new ArrayAdapter<String>(ListMahasiswaActivity.this, android.R.layout.simple_list_item_1,items));*/
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

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda memilih = " +  items [i], Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    private void addData(){
        dataMhsArrayList = new ArrayList<>();
        dataMhsArrayList.add(new DataMhs("Aru","72160029","Pria","Programmer","Usaha tidak menghianati hasil"));
        dataMhsArrayList.add(new DataMhs("Harold", "72160050", "Pria", "Pengusaha", "Hidup Santuy"));
        dataMhsArrayList.add(new DataMhs("Brian", "72160025", "Pria", "Pengusaha", "Kejarlah ilmu sampai keCina"));
        dataMhsArrayList.add(new DataMhs("Erick", "72160085", "Pria", "Programmer", "Hormati orang tua"));
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
