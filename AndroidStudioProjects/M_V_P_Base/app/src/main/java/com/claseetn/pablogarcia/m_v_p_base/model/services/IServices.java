package com.claseetn.pablogarcia.m_v_p_base.model.services;

import com.claseetn.pablogarcia.m_v_p_base.dto.Product;

import java.util.ArrayList;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

import static android.R.attr.path;

/**
 * Created by pablo.garcia on 15/11/2017.
 */

public interface IServices {
    @GET("/products")
    public ArrayList<Product> getProducts();

    @POST("/products")
    Product insertProduct(@Body Product product);
    @PUT("/products/{id}")
    Product updateProduct(@Path("id") String id, @Body Product product);
    @DELETE("/products/{id}")
    Product deleteProduct(@Path("id") String id);
}