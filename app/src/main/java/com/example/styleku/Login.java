package com.example.styleku;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity{
    ProgressDialog progressDialog;
    EditText username_user,password_user,email_user;
    EditText username_seller,password_seller,email_seller,nm_toko_seller;
    Button login_user,login_seller,Dregister_user,register_seller;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(Login.this);
        username_user = (EditText) findViewById(R.id.edit_usernameLogin);
        password_user = (EditText) findViewById(R.id.edit_passwordLogin);
        email_user = (EditText) findViewById(R.id.edit_emailRegisterUser);
        username_seller = (EditText) findViewById(R.id.edit_usernameLogin);
        password_seller = (EditText) findViewById(R.id.edit_passwordLogin);
        email_seller = (EditText) findViewById(R.id.edit_emailRegisterSeller);
        login_seller = (Button) findViewById(R.id.btn_loginSeller) ;
        login_user = (Button) findViewById(R.id.btn_loginCustomer);
        Dregister_user = findViewById(R.id.btn_toRegisterUser);
        register_seller = findViewById(R.id.btn_toRegisterSeller);
        sharedPreferences = this.getSharedPreferences(getString(R.string.shared_key),Context.MODE_PRIVATE);
        cekSharedUser();
        cekSharedSeller();

        register_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerSeller = new Intent(Login.this,Register_Seller.class);
                startActivity(registerSeller);
            }
        });

        Dregister_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerUser = new Intent ( Login.this,Register.class);
                startActivity(registerUser);

            }
        });
        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String susername_user = username_user.getText().toString();
                String spassword_user = password_user.getText().toString();

                cekloginUser(susername_user,spassword_user);

            }
        });
        login_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String susername_seller = username_seller.getText().toString();
                String spassword_seller = password_seller.getText().toString();

                cekloginSeller(susername_seller,spassword_seller);
            }
        });

    }
    public void cekSharedSeller(){
        String seller = sharedPreferences.getString(getString(R.string.username_seller_key),"");
        if(seller.length() > 3){
            toMainSeller();
        }
    }
    public void toMainSeller(){
        Intent dasboardSeller = new Intent(Login.this,DashboardSeller.class);
        dasboardSeller.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(dasboardSeller);
    }
    public void cekSharedUser(){
        String user = sharedPreferences.getString(getString(R.string.username_user_key),"");
        if(user.length() > 3){
            toMainUser();
        }
    }
    public void toMainUser(){
        Intent dasboardUser = new Intent(Login.this,DashboardUser.class);
        dasboardUser.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(dasboardUser);
    }
    public void cekloginUser(final String username_users,final  String password_users){
        if (cekKoneksi()){
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DBaddres.server_login_user, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String server = jsonObject.getString("server_response");
                        if (server.equals ("[{\"status\":\"OK\"}]")){
                            String pref_susername_user = username_user.getText().toString();
                            sharedPreferences.edit().putString(getString(R.string.username_user_key),pref_susername_user).apply();
                            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_LONG).show();
                            Intent dasboardUser = new Intent(Login.this,DashboardUser.class);
                            startActivity(dasboardUser);

                        }else{
                            Toast.makeText(getApplicationContext(),"Username atau Password salah",Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("username_User",username_users);
                    params.put("password_User",password_users);
                    return params;
                }
            };
            vollyKoneksi.getInstance(Login.this).addRequestQue(stringRequest);
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
    public void cekloginSeller(final String username_sellers,final  String password_sellers){
        if (cekKoneksi()){
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DBaddres.server_login_seller, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String server = jsonObject.getString("server_response");
                        if (server.equals ("[{\"status\":\"OK\"}]")){
                            String pref_susername_seller = username_seller.getText().toString();
                            sharedPreferences.edit().putString(getString(R.string.username_seller_key),pref_susername_seller).apply();
                            Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_LONG).show();
                            Intent dasboardUser = new Intent(Login.this,DashboardSeller.class);
                            startActivity(dasboardUser);

                        }else{
                            Toast.makeText(getApplicationContext(),"Username atau Password salah",Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("username_Seller",username_sellers);
                    params.put("password_Seller",password_sellers);
                    return params;
                }
            };
            vollyKoneksi.getInstance(Login.this).addRequestQue(stringRequest);
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
    public boolean cekKoneksi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
