package com.example.styleku;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class vollyKoneksi {
    private  static vollyKoneksi vInstace;
    private RequestQueue requestQueue;
    private  static Context vcontext;

    private vollyKoneksi (Context context){
        vcontext = context;
        requestQueue = getRequestQueue();
    }
    private  RequestQueue getRequestQueue(){
        if ( requestQueue == null){
            requestQueue = Volley.newRequestQueue(vcontext.getApplicationContext());

        }
        return requestQueue;
    }
    public static  synchronized vollyKoneksi getInstance(Context context){
        if ( vInstace == null){
            vInstace = new vollyKoneksi(context);
        }
        return vInstace;
    }
    public<T> void addRequestQue(Request<T>request){
        getRequestQueue().add(request);
    }
}
