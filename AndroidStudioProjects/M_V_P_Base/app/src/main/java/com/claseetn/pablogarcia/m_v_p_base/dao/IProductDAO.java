package com.claseetn.pablogarcia.m_v_p_base.dao;

import com.claseetn.pablogarcia.m_v_p_base.dto.Product;

import java.util.ArrayList;

/**
 * Created by pablo.garcia on 12/12/2017.
 */

public interface IProductDAO {
    public ArrayList<Product> getProducts();

    Product insertProduct(Product product);

    Product updateProduct(Product product);

    Product deleteProduct(Product product);
}
