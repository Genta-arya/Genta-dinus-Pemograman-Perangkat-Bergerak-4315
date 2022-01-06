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

public class DashboardSeller extends AppCompatActivity {
    Button logout;
    TextView username_seller;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_seller);
        logout = findViewById(R.id.buttonLogoutSeller);
        username_seller = findViewById(R.id.textView_username_seller);
        sharedPreferences = this.getSharedPreferences(getString(R.string.shared_key), Context.MODE_PRIVATE);
        username_seller.setText("Selamat Datang "+sharedPreferences.getString(getString(R.string.username_seller_key),"-"));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                Intent keluar = new Intent(DashboardSeller.this,Login.class);
                keluar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getApplicationContext(),"Logout Berhasil",Toast.LENGTH_SHORT).show();
                startActivity(keluar);
            }
        });
    }
}