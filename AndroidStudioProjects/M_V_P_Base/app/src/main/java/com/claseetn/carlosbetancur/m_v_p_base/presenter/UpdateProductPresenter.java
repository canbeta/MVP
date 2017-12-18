package com.claseetn.carlosbetancur.m_v_p_base.presenter;


import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.model.repositories.IRepository;
import com.claseetn.carlosbetancur.m_v_p_base.model.repositories.Repository;
import com.claseetn.carlosbetancur.m_v_p_base.view.activities.IInsertProductView;
import com.claseetn.carlosbetancur.m_v_p_base.view.activities.IUpdateProducView;
import com.claseetn.carlosbetancur.m_v_p_base.R;

/**
 * Created by carlos andres betancur on 21/11/2017.
 */

public class UpdateProductPresenter extends BasePresenter<IUpdateProducView>{

    private IRepository repository;

    public UpdateProductPresenter(){
        this.repository = new Repository();
    }

    public UpdateProductPresenter(IRepository repository){
        this.repository = repository;
    }

    public void updateProduct(final Product product){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                updateProductRepository (product);
            }
        });
        hilo.start();
    }

    private void updateProductRepository(Product product){
        try{
            // TODO VALIDAR DATOS
            repository.updateProduct(product);
            getView().showResult();
        }catch (Exception ex){
            ex.printStackTrace();
            getView().showToast(R.string.error_invalid_number);
        }
    }

    public void deleteProduct(final Product product) {

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                deleteProductRepository (product);
            }
        });
        hilo.start();
    }

    private void deleteProductRepository(Product product) {
        try{
            // TODO VALIDAR DATOS
            repository.deleteProduct(product);
            getView().showResult();
        }catch (Exception ex){
            ex.printStackTrace();
            getView().showToast(R.string.error_invalid_number);
        }
    }
}