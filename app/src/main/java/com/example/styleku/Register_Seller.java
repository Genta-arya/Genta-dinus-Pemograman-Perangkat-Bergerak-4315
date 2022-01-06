package com.example.styleku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register_Seller extends AppCompatActivity {
    EditText username_seller,password_seller,email_seller,nm_toko_seller;
    Button register_seller ;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_seller);
        username_seller = findViewById(R.id.edit_usernameRegisterSeller);
        password_seller = findViewById(R.id.edit_passwordRegisterSeller);
        email_seller = findViewById(R.id.edit_emailRegisterSeller);
        register_seller = findViewById(R.id.btn_registerSeller);
        progressDialog = new ProgressDialog(Register_Seller.this);

        register_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String susername_seller = username_seller.getText().toString();
                String semail_seller = email_seller.getText().toString();
                String spassword_seller = password_seller.getText().toString();


                DataServerSeller(susername_seller,semail_seller,spassword_seller);


            }

        });
    }
    public void DataServerSeller(final String username_seller , final  String email_seller , final  String password_seller){
        if ( cekKoneksi()){
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DBaddres.server_register_seller,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String server_res = jsonObject.getString("server_response");
                                if (server_res.equals("[{\"status\":\"OK\"}]")){
                                    Intent loginintents = new Intent(Register_Seller.this, Login.class);
                                    startActivity(loginintents);
                                    Toast.makeText(getApplicationContext(),"Registrasi Berhasil",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getApplicationContext(),"Username Telah Digunakan",Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("username_Seller",username_seller);
                    params.put("email_Seller",email_seller);
                    params.put("password_Seller",password_seller);
                    return params;
                }
            };
            vollyKoneksi.getInstance(Register_Seller.this).addRequestQue(stringRequest);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.cancel();
                }
            },2000);

        }else{
            Toast.makeText(getApplicationContext(),"Tidak ada Internet",Toast.LENGTH_SHORT).show();
        }

    }
    public boolean cekKoneksi(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return ( networkInfo != null && networkInfo.isConnected()) ;
    }

}