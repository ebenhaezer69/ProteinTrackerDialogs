package com.example.proteintracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class DialogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        Button settingButton = (Button) findViewById(R.id.settingBtn);
        settingButton.setOnClickListener(mySettingBtn);

        Button resetButton = (Button) findViewById(R.id.btnReset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogsActivity.this);
                builder.setMessage("Apakah anda yakin mereset nilai protein?").setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogsActivity.this, "Tidak Jadi Reset", Toast.LENGTH_SHORT).show();
                    }
                })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogsActivity.this, "Melakukan Reset", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        SharedPreferences pref = DialogsActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin = pref.getString("isLogin",null);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(myBtnLoginClick);

        if (statusLogin != null){
            loginBtn.setText("Logout");
        } else {
            loginBtn.setText("Login");
        }
    }

    private View.OnClickListener mySettingBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(DialogsActivity.this, SettingsProteinTrackerActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences pref  = DialogsActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
            String statusLogin = pref.getString("isLogin", null);
            SharedPreferences.Editor edit = pref.edit();

            Button loginBtn = (Button) findViewById(R.id.loginBtn);
            if (statusLogin != null){
                edit.putString("isLogin", null);
                loginBtn.setText("Login");
            } else {
                edit.putString("isLogin","Admin");
                loginBtn.setText("Logout");
            }
            edit.commit();
        }
    };

    public void GoToLogin(View view) {
        Intent intent = new Intent(DialogsActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
