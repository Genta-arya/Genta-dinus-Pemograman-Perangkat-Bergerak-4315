package com.example.styleku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class item extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String server_list_barang = "http://192.168.0.102/loginregister_styleku_volley/view_toko.php";
    ListView list;
    SwipeRefreshLayout swipe;
    List<barang_list> tokolist = new ArrayList<barang_list>();
    barangadapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barang);
        swipe = findViewById(R.id.swipe);
        list = findViewById(R.id.list_barang);
        adapter = new barangadapter(item.this,tokolist);
        list.setAdapter(adapter);

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public  void onItemClick(AdapterView<?>parent,View view,int position,long id){
//                final String idx = tokolist.get(position).getId_toko();
//                detailtoko(idx);
//
//            }
//
//        });


        swipe.setOnRefreshListener(this);
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
                tokolist.clear();
                adapter.notifyDataSetChanged();
                volley();
            }
        });

    }



    @Override
    public void onRefresh() {
        tokolist.clear();
        adapter.notifyDataSetChanged();
        volley();
    }
    private void volley(){
        tokolist.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server_list_barang, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);

                        barang_list data = new barang_list();

                        data.setId_barang(object.getString("id_barang"));
                        data.setNama_Sellers(object.getString("username_seller"));
                        data.setNama_tokos(object.getString("nama_toko"));
                        data.setNama_barangs(object.getString("nama_brg"));
                        data.setHargas(object.getString("harga_brg"));
                        data.setQtyss(object.getString("qty"));

                        tokolist.add(data);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG,"Error: "+error.getMessage());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);
    }

}