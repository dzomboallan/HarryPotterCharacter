package com.example.harrypottercharacters;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private RequestQueue requestQueue;
    private static VolleySingleton rInstance;

    private VolleySingleton(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getrInstance(Context context){
        if (rInstance == null){
            rInstance = new VolleySingleton(context);
        }
        return rInstance;
    }

    public RequestQueue getRequestQueue(){return requestQueue;}
}
