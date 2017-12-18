package com.claseetn.carlosbetancur.m_v_p_base.presenter;


import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.model.repositories.IRepository;
import com.claseetn.carlosbetancur.m_v_p_base.model.repositories.Repository;
import com.claseetn.carlosbetancur.m_v_p_base.view.activities.IProductView;
import com.claseetn.carlosbetancur.m_v_p_base.R;

import java.util.ArrayList;

/**
 * Created by carlos andres betancur on 21/11/2017.
 */

public class ProductPresenter extends BasePresenter<IProductView>{

    private IRepository repository;

    public ProductPresenter (){
        this.repository = new Repository();
    }

    public ProductPresenter (IRepository repository){
        this.repository = repository;
    }

    public void getProductList(){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                getProductListRepository();
            }
        });
        hilo.start();
    }

    private void getProductListRepository (){
        try {
            ArrayList<Product> products;
            products = repository.getProducts();
            getView().setProducts(products);
        }catch (Exception ex){
            ex.printStackTrace();
            getView().showToast (R.string.error_invalid_number);
        }
    }
}