package com.claseetn.pablogarcia.m_v_p_base.helper;

import com.claseetn.pablogarcia.m_v_p_base.model.services.IServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by pablo.garcia on 22/11/2017.
 */

public class ServicesFactory {

    private static final String API_BASE_PATH = Constants.URL_BASE_TESTING;
    private static final String API_XML_BASE_PATH = Constants.URL_XML_BASE_TESTING;
    RestAdapter restAdapter;



    public ServicesFactory(TypeDecryption typeDecryption) {
        Converter converter = null;
        String urlBase = "";
        switch (typeDecryption){
            case XML:
                urlBase = API_XML_BASE_PATH;
                //converter = new SimpleXMLConverter();
                break;
            case JSON:
                urlBase = API_BASE_PATH;
                converter = getGsonConverter();
                break;
        }
        createServicesFactoryInstance (converter, urlBase);
    }

    private void createServicesFactoryInstance(Converter converter, String urlBase) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS);
        restAdapter = new RestAdapter.Builder().setEndpoint(urlBase)
                .setConverter(converter)
                .setClient(new OkClient(okHttpClient))
                .build();
    }

    private Converter getGsonConverter() {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return new GsonConverter(gson);

    }

    public Object getInstance(Class service) {
        return restAdapter.create(service);
    }
}
