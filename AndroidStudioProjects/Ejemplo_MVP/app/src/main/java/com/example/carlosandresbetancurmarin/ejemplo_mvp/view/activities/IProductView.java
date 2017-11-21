package com.example.carlosandresbetancurmarin.ejemplo_mvp.view.activities;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.dto.Product;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.IBaseView;

import java.util.ArrayList;

/**
 * Created by carlosandresbetancurmarin on 21/11/17.
 */

public interface IProductView extends IBaseView{

    public void setProducts(ArrayList<Product> products);


    void showToast(int error_invalid_number);
}
