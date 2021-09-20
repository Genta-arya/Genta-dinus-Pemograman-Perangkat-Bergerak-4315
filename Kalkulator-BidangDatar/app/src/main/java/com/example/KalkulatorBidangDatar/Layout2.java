package com.example.KalkulatorBidangDatar;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.KalkulatorBidangDatar.databinding.ActivityMain2Binding;

public class Layout2 extends AppCompatActivity {

    public EditText txtDiameter;
    public TextView txtHasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        attributLingkaran();
    }


    public void attributLingkaran(){
        txtDiameter = findViewById(R.id.txtDiameter);
        txtHasil2 = findViewById(R.id.txtHasil2);
    }
    public void hitungLingkaranLuas(View v){
        float desimal = Float.parseFloat(txtDiameter.getText().toString());
        float hasil3 = (float)3.14 * ((float) desimal * (float) desimal);
        txtHasil2.setText(("Luas Lingakaran nya yaitu : " + hasil3  + "\n Rumus : 3.14 * (diameter * diameter) "));
    }

    public  void hitungLingkaranKeliling(View  v){
        float desimal = Float.parseFloat(txtDiameter.getText().toString());
        float hasil3 = 2 *(float)3.14 * (float) desimal ;
        txtHasil2.setText(("Keliling Lingakaran nya yaitu : " + hasil3  + "\n Rumus : 2 * 3.14 * diameter "));
    }
}