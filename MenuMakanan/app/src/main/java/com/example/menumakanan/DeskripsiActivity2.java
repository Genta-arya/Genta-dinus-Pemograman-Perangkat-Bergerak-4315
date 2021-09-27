package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DeskripsiActivity2 extends AppCompatActivity {

    ImageView imageDeskripsi;
    TextView textDesc2;
    TextView textDesc3;
    TextView textInfomakanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi2);

        imageDeskripsi = findViewById(R.id.imageDeskripsi);
        textDesc2 = findViewById((R.id.textDesc2));
        textDesc3 = findViewById((R.id.textDesc3)) ;
        textInfomakanan = findViewById(R.id.textInfomakanan);
        getData();
    }
    private void getData(){
        if(getIntent().hasExtra("foto_makanan") && getIntent().hasExtra("nama_makanan") && getIntent().hasExtra("deskripsi_makanan") && getIntent().hasExtra("harga_makanan"));{
            String gambarmakanan = getIntent().getStringExtra("foto_makanan");
            String namamakanan = getIntent().getStringExtra("nama_makanan");
            String deskripsimakanan = getIntent().getStringExtra("deskripsi_makanan");
            String hargamakanan = getIntent().getStringExtra("harga_makanan");
            setAktif(gambarmakanan,namamakanan,deskripsimakanan,hargamakanan);
        }
    }
    private void setAktif(String gambarmakanan,String namamakanan,String deskripsimakanan,String hargamakanan){
        Glide.with(this).asBitmap().load(gambarmakanan).into(imageDeskripsi);
        textDesc2.setText(namamakanan);
        textDesc3.setText(hargamakanan);
        textInfomakanan.setText(deskripsimakanan);


    }
}