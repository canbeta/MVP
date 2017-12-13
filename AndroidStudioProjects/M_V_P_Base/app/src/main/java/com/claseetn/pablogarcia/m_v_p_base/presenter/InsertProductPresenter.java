package com.claseetn.pablogarcia.m_v_p_base.presenter;

import com.claseetn.pablogarcia.m_v_p_base.R;
import com.claseetn.pablogarcia.m_v_p_base.dto.Product;
import com.claseetn.pablogarcia.m_v_p_base.model.repositories.IRepository;
import com.claseetn.pablogarcia.m_v_p_base.model.repositories.Repository;
import com.claseetn.pablogarcia.m_v_p_base.view.activities.IInsertProductView;
import com.claseetn.pablogarcia.m_v_p_base.view.activities.IProductView;

import java.util.ArrayList;

/**
 * Created by pablo.garcia on 21/11/2017.
 */

public class InsertProductPresenter extends BasePresenter<IInsertProductView>{

    private IRepository repository;

    public InsertProductPresenter(){
        this.repository = new Repository();
    }

    public InsertProductPresenter(IRepository repository){
        this.repository = repository;
    }

    public void insertProduct(final Product product){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                insertProductRepository (product);
            }
        });
        hilo.start();
    }

    private void insertProductRepository(Product product){
        try{
            // TODO VALIDAR DATOS
            repository.insertProduct(product);
            getView().showResult();
        }catch (Exception ex){
            ex.printStackTrace();
            getView().showToast(R.string.error_invalid_number);
        }
    }
}