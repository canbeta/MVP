package com.example.carlosandresbetancurmarin.ejemplo_mvp.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.sql.Connection;

/**
 * Created by carlos andres betancur marin on 16/11/17.
 */

public class ValidateInternet implements IvalidateInternet {

    private Context context;// context es la vista donde esta trabajando

    public ValidateInternet(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnected() {
        boolean res = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        // valida que si esta conectado o intes intentado conectar que este conectado y este disponible
        res = networkInfo != null && networkInfo.isConnectedOrConnecting() && networkInfo.isAvailable() && networkInfo.isConnected();
        return res;


    }


}
