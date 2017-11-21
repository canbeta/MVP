package com.example.carlosandresbetancurmarin.ejemplo_mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.R;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.dto.Product;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.presenter.ProductPresenter;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.activities.IProductView;

import java.util.ArrayList;

public class ProductActivity extends BaseActivity<ProductPresenter> implements IProductView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    @Override
    public void setProducts(ArrayList<Product> products) {

    }

    @Override
    public void showToast(int error_invalid_number) {

    }
}
