package com.example.styleku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardUser extends AppCompatActivity {
    Button logout,toko;
    TextView usernamekey;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);
        logout = findViewById(R.id.buttonLogoutUser);
        usernamekey = findViewById(R.id.textView_username_user);
        sharedPreferences = this.getSharedPreferences(getString(R.string.shared_key), Context.MODE_PRIVATE);
        usernamekey.setText("Selamat Datang "+sharedPreferences.getString(getString(R.string.username_user_key),"-"));
        toko = findViewById(R.id.btn_listToko);

        toko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn_toko = new Intent(DashboardUser.this, list_toko.class);
                startActivity(btn_toko);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                Intent keluar = new Intent(DashboardUser.this,Login.class);
                keluar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getApplicationContext(),"Logout Berhasil",Toast.LENGTH_SHORT).show();
                startActivity(keluar);
            }
        });


    }

}