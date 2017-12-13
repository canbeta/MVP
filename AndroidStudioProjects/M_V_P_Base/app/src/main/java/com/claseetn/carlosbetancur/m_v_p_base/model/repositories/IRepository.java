package com.claseetn.carlosbetancur.m_v_p_base.model.repositories;

import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;

import java.util.ArrayList;

/**
 * Created by pablo.garcia on 15/11/2017.
 */

public interface IRepository {
    public ArrayList<Product> getProducts();

    Product insertProduct(Product product); //trhows

    Product updateProduct(Product product);

    Product deleteProduct(Product product);
}
