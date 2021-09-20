package com.example.KalkulatorBidangDatar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public  class Layout1 extends AppCompatActivity {
//    private Button btnHitung1;
    public EditText txt_panjang, txt_lebar;
    public TextView txtHasil;
    public EditText txt_alas;
    public EditText txt_tinggi;
    public TextView txtHasil1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        attributPersgi();
        attributSegitiga();




    }
    public void attributPersgi(){
        txt_panjang = findViewById(R.id.txtPanjang);
        txt_lebar = findViewById(R.id.txtLebar);
        txtHasil = findViewById(R.id.txtHasil);
    }
    public void hitungPersegiluas(View v){
        int panjang = Integer.parseInt(txt_panjang.getText().toString()) * Integer.parseInt((txt_lebar.getText().toString()));
//        int hasil = panjang;
        txtHasil.setText(("Luas Persegi nya yaitu :  " + panjang + "\n Rumus : Panjang * Lebar "));
    }

    public void hitungPersegiKeliling(View v){
        int panjang = Integer.parseInt(txt_panjang.getText().toString());
        int lebar = Integer.parseInt((txt_lebar.getText().toString()));
        int hasil = 2*panjang + 2*lebar;
        txtHasil.setText(("Keliling Persegi nya yaitu : "+ hasil + "\n Rumus : 2 * Panjang + 2 * Lebar "));
    }

    public void attributSegitiga(){
        txt_tinggi = findViewById(R.id.txtTinggi);
        txt_alas = findViewById(R.id.txtAlas);
        txtHasil1 = findViewById(R.id.txtHasil1);
    }

    public void hitungSegitigaLuas(View v){
        int alas = Integer.parseInt(txt_alas.getText().toString());
        int tinggi = Integer.parseInt(txt_tinggi.getText().toString());
        double hasil2 = 0.5 * (double)alas * (double)tinggi;
        txtHasil1.setText(("Luas Segitiga nya yaitu : " + hasil2 + "\n Rumus : 0,5 * Panjang * Lebar "));

    }
    public  void hitungSegitigaKeliling(View v){
        int alas = Integer.parseInt(txt_alas.getText().toString());
        double hasil2 = 3 * (double)alas ;
        txtHasil1.setText(("Keliling Segitiga nya yaitu : " + hasil2  + "\n Rumus : 3 * Alas "));

    }

    public void pindah(View view){
        Intent intent = new Intent( Layout1.this, Layout2.class);
        startActivity(intent);
    }


}

