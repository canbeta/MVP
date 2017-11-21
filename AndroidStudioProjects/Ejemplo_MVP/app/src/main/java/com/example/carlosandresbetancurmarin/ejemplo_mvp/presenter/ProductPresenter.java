package com.example.carlosandresbetancurmarin.ejemplo_mvp.presenter;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.R;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.dto.Product;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.model.repositories.IRepository;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.model.repositories.Repository;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.activities.IProductView;

import java.util.ArrayList;

/**
 * Created by carlosandresbetancurmarin on 21/11/17.
 */

public class ProductPresenter extends BasePresenter<IProductView> {

    private IRepository repository;

    public ProductPresenter() {
        this.repository= new Repository();
    }

    public ProductPresenter(IRepository iRepository) {
        this.repository = iRepository;
    }


public void getProductList() {

    Thread hilo = new Thread(new Runnable() {
        @Override
        public void run() {
            getProductListRepository();

        }
    });
    hilo.start();
}

    private void getProductListRepository(){
        try{
            ArrayList<Product> products;
            products = repository.getProducts();
            getView().setProducts(products);

        }catch (Exception ex){
            ex.printStackTrace();
            getView().showToast(R.string.error_invalid_number);
        }

    }
    }
