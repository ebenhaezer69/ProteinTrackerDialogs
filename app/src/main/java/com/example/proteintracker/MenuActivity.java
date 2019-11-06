package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Context Menu
        String ContMenu [] = {"ayam", "kuda", "singa", "kucing"};
        ListView lv = (ListView) findViewById(R.id.lstView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ContMenu);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
        //Context Menu
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Silahkan pilih");
        menu.add(0,view.getId(), 0,"Simpan");
        menu.add(0,view.getId(), 0, "Tidak");
    }

    public boolean onContextItemSelected(MenuItem item){
        if (item.getTitle() == "Simpan"){
            Toast.makeText(getApplicationContext(), "Ex : item disimpan", Toast.LENGTH_SHORT).show();
        } else if(item.getTitle() == "Tidak"){
            Toast.makeText(getApplicationContext(), "Tidak disimpan", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
    }
    //Context Menu

    //nampilin icon titik 3 atas kanan
    //inflater untuk layout nya bisa di gunakan di banyak activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    //item selected option menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.item1) {
            Toast.makeText(getApplicationContext(), "menu pertama di klick", Toast.LENGTH_SHORT).show();
        } if (item.getItemId() == R.id.item2){
            Toast.makeText(getApplicationContext(), "menu kedua di klick", Toast.LENGTH_SHORT).show();
        } if (item.getItemId() == R.id.item3){
            Toast.makeText(getApplicationContext(), "menu ketiga di klick", Toast.LENGTH_SHORT).show();
        } if (item.getItemId() == R.id.item4){
            Toast.makeText(getApplicationContext(), "menu keempat diklcik", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
