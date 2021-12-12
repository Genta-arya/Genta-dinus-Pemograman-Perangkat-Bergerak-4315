package com.example.kalkulatorsharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;


public class Kalkulator_Activty extends AppCompatActivity {
    public EditText angka1, angka2;
    public TextView Hasil;
    public TextView textHistory;
    public Button tombol;
    public RadioButton tambah,kurang,kali,bagi;
    public RadioGroup radiogrup;
    SharedPreferences pref;
    Gson gson;
    ArrayList<history> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = this.getSharedPreferences(getString(R.string.noteKey),Context.MODE_PRIVATE);
        gson = new GsonBuilder().create();
        angka1 = findViewById(R.id.editText_angka1);
        angka2 = findViewById(R.id.editText_angka2);
        tambah = findViewById(R.id.radioButtonTambah);
        kurang = findViewById(R.id.radioButtonKurang);
        kali = findViewById(R.id.radioButtonKali);
        bagi = findViewById(R.id.radioButtonBagi);
        Hasil = findViewById(R.id.textViewHasil);
        tombol = findViewById(R.id.BtnHitung);
        radiogrup = findViewById(R.id.radioGrup);
        textHistory = findViewById(R.id.textHistory);


    }
    @Override
    protected  void onResume(){
        super.onResume();

        String strHistory = pref.getString(getString(R.string.noteKey),"[]");
        notes = gson.fromJson(strHistory,new TypeToken<ArrayList<history>>(){}.getType());
        String contentText = "";
        for (history notes: notes){
            contentText += notes.toString();
        }
        textHistory.setText(contentText) ;
    }

    public void hitungClick(View v) {

        Intent it = new Intent(this,Kalkulator_Activty.class);

        int parse_angka1 = Integer.parseInt(angka1.getText().toString());
        int parse_angka2 = Integer.parseInt(angka2.getText().toString());
        int hasil ;
        double bagihasil;
        if (tambah.isChecked()) {
            hasil = parse_angka1 + parse_angka2;
            Hasil.setText(parse_angka1+"+"+parse_angka2+"="+hasil);
            saveHistroy();



        } else if (kurang.isChecked()) {
            hasil = parse_angka1 - parse_angka2;
            Hasil.setText(parse_angka1+"-"+parse_angka2+"="+hasil);
            saveHistroy();


        } else if (kali.isChecked()) {
            hasil = parse_angka1 * parse_angka2;
            Hasil.setText(parse_angka1+"x"+parse_angka2+"="+hasil);
            saveHistroy();

        } else if (bagi.isChecked()) {
            bagihasil = parse_angka1 / parse_angka2;
            Hasil.setText(parse_angka1+"/"+parse_angka2+"="+bagihasil);
//
            saveHistroy();

        }
        startActivity(it);

//


    }
    public void saveHistroy(){
        String strListHistory = pref.getString(getString(R.string.noteKey),"[]");
        notes = gson.fromJson(strListHistory,new TypeToken<ArrayList<history>>(){}.getType());
        if (notes == null) notes = new ArrayList<>();
        notes.add(new history(Hasil.getText().toString()));

        strListHistory=gson.toJson(notes);
        pref.edit().putString(getString(R.string.noteKey),strListHistory).apply();
        finish();

    }

}





