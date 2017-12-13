package com.claseetn.carlosbetancur.m_v_p_base.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by pablo.garcia on 16/11/2017.
 */

public class ValidateInternet implements IValidateInternet{

    private Context context;

    public ValidateInternet (Context context){
        this.context = context;
    }

    @Override
    public boolean isConneted() {
        boolean res = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        // validar que esta conectado o intentando conectar que este conectada y esta deisponible
        res = networkInfo != null
                && networkInfo.isConnectedOrConnecting()
                && networkInfo.isAvailable()
                && networkInfo.isConnected();
        return res;
    }
}
