package com.claseetn.carlosbetancur.m_v_p_base.dao;

import android.database.sqlite.SQLiteDatabase;


import com.claseetn.carlosbetancur.m_v_p_base.providers.DbContentProvider;

import java.util.ArrayList;

/**
 * Created by carlos betancur on 12/12/2017.
 */

public class ProductDAOImpl extends DbContentProvider implements com.claseetn.pablogarcia.m_v_p_base.dao.IProductDAO, IProductSheme{


    public ProductDAOImpl (SQLiteDatabase db){
        super(db);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }

    @Override
    public Product insertProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Product product) {
        return null;
    }
}
