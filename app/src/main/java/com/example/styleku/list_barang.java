package com.example.styleku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import  com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static android.content.ContentValues.TAG;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class list_barang extends AppCompatActivity    {

    TextView id_brg,username,namatk,nmbrg,hrg,qty;
    String id_barangs,username_brg_seller,nama_toko,nama_brgs,harga_brgs,qtys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_barang);

        id_brg= findViewById(R.id.id_barangs);
        username = findViewById(R.id.username_brg_seller);
        namatk = findViewById(R.id.nama_toko);
        nmbrg = findViewById(R.id.nama_brgs);
        hrg = findViewById(R.id.harga_brgs);
        qty = findViewById(R.id.qtys);

        id_barangs = getIntent().getStringExtra("id_barang");
        username_brg_seller= getIntent().getStringExtra("username_seller");
        nama_toko = getIntent().getStringExtra("nama_toko");
        nama_brgs = getIntent().getStringExtra("nama_brg");
        harga_brgs = getIntent().getStringExtra("harga_brg");
        qtys = getIntent().getStringExtra("qty");

        id_brg.setText(id_barangs);
        username.setText(username_brg_seller);
        namatk.setText(nama_toko);
        nmbrg.setText(nama_brgs);
        hrg.setText(harga_brgs);
        qty.setText(qtys);

    }
}