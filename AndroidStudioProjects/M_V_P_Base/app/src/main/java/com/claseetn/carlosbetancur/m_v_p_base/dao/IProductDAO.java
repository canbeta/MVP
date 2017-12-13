package com.claseetn.carlosbetancur.m_v_p_base.dao;


import java.util.ArrayList;

/**
 * Created by pablo.garcia on 12/12/2017.
 */

public interface IProductDAO {
    public ArrayList<com.claseetn.pablogarcia.m_v_p_base.dto.Product> getProducts();

    Product insertProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(Product product);
}
