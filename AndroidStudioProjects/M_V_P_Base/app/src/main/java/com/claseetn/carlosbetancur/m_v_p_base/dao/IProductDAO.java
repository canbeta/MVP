package com.claseetn.carlosbetancur.m_v_p_base.dao;


import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;

import java.util.ArrayList;

/**
 * Created by carlos andres betancur on 12/12/2017.
 */

public interface IProductDAO {

    public ArrayList<Product> getProducts();

    boolean insertProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(Product product);
}
