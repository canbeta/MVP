package com.claseetn.carlosbetancur.m_v_p_base.model.repositories;

import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.helper.ServicesFactory;
import com.claseetn.carlosbetancur.m_v_p_base.helper.ServicesFactory;
import com.claseetn.carlosbetancur.m_v_p_base.helper.TypeDecryption;
import com.claseetn.carlosbetancur.m_v_p_base.model.services.IServices;

import java.util.ArrayList;

import retrofit.RetrofitError;

/**
 * Created by pablo.garcia on 15/11/2017.
 */

public class Repository implements IRepository{

    private IServices services;

    public Repository (){

        ServicesFactory servicesFactory = new ServicesFactory (TypeDecryption.JSON);
        services = (IServices) servicesFactory.getInstance (IServices.class);

    }
    @Override
    public ArrayList<Product> getProducts()//throws RepositoryError{
     {
        //try{
            return services.getProducts();
        //}catch (RetrofitError retrofitError){
        /*throw MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
        }*/
        
    }

    @Override
    public Product insertProduct (Product product) //throws RepositoryError{
    {
        //try{
            return services.insertProduct(product);
        /*}catch (RetrofitError retrofitError){
            throw MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
        }*/
    }

    @Override
    public Product updateProduct(Product product) //throws RepositoryError{
     {
        //try{
        return services.updateProduct(product.getId(), product);
        /*}catch (RetrofitError retrofitError){
            throw MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
        }*/
    }

    @Override
    public Product deleteProduct(Product product) {
        return services.deleteProduct(product.getId());
    }
}
