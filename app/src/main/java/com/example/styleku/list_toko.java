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

public class list_toko extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String server_list_toko = "http://192.168.0.102/loginregister_styleku_volley/list_toko.php";
    public static final String server_list_barang = "http://192.168.0.102/loginregister_styleku_volley/view_toko.php";
    ListView list;
    SwipeRefreshLayout swipe;
    List<data_list> tokolist = new ArrayList<data_list>();
    tokoAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_toko);
        swipe = findViewById(R.id.swipe);
        list = findViewById(R.id.list_tokoh);
        adapter = new tokoAdapter(list_toko.this,tokolist);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public  void onItemClick(AdapterView<?>parent,View view,int position,long id){
                String idx = tokolist.get(position).getNama_toko();
                Toast.makeText(getApplicationContext(),"Toko : "+idx,Toast.LENGTH_SHORT).show();
//                data_list data_list = (data_list)adapter.getItem(position);
//                Toast.makeText(
//                        getApplicationContext(),
//                        data_list.getNama_toko(),
//                        Toast.LENGTH_SHORT).show();
                if(!idx.isEmpty()){
                    Intent loginintent = new Intent(list_toko.this, item.class);
                    startActivity(loginintent);
//                    detailtoko(idx);

                }



            }

        });


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
    private void detailtoko(String id){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_list_barang, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    String idx = object.getString("id_barang");
                    String sellerx = object.getString("username_seller");
                    String nm_tokox = object.getString("nama_toko");
                    String hrg_brgx = object.getString("harga_brg");
                    String qtyx = object.getString("qty");

                    Intent intent = new Intent(list_toko.this, list_barang.class);
                    intent.putExtra("id_barang", idx);
                    intent.putExtra("username_seller", sellerx);
                    intent.putExtra("nama_toko", nm_tokox);
                    intent.putExtra("harga_brg", hrg_brgx);
                    intent.putExtra("qty", qtyx);

                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(list_toko.this,"gagal koneksi",Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama_toko",id);
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
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


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server_list_toko, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);

                        data_list data = new data_list();

                        data.setId_toko(object.getString("id_toko"));
                        data.setNama_toko(object.getString("nama_toko"));


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