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

public class Register extends AppCompatActivity {
    ProgressDialog progressDialog;
    EditText username_user,password_user,email_user;

    Button login_user,login_seller,register_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(Register.this);
        username_user = (EditText) findViewById(R.id.edit_usernameRegisterUser);
        password_user = (EditText) findViewById(R.id.edit_passwordRegisterUser);
        email_user = (EditText) findViewById(R.id.edit_emailRegisterUser);
        register_user = findViewById(R.id.btn_registerCustomer);


        register_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String susername_user = username_user.getText().toString();
                String semail_user = email_user.getText().toString();
                String spassword_user = password_user.getText().toString();

//
                DataServerUser(susername_user,semail_user,spassword_user);
            }
        });

    }

    public void DataServerUser(final String username_user,final  String email_user , final  String password_user){
        if ( cekKoneksi()){
            progressDialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, DBaddres.server_register_user,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String server_res = jsonObject.getString("server_response");
                                if (server_res.equals("[{\"status\":\"OK\"}]")){
                                    Toast.makeText(getApplicationContext(),"Registrasi Berhasil",Toast.LENGTH_SHORT).show();
                                    Intent loginintent = new Intent(Register.this, Login.class);
                                    startActivity(loginintent);
                                }if(server_res.equals("[{\"status\":\"null\"}]")){
                                    Toast.makeText(getApplicationContext(),"Username Telah Digunakan",Toast.LENGTH_SHORT).show();

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
                    params.put("username_User",username_user);
                    params.put("email_User",email_user);
                    params.put("password_User",password_user);
                    return params;
                }
            };
            vollyKoneksi.getInstance(Register.this).addRequestQue(stringRequest);
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