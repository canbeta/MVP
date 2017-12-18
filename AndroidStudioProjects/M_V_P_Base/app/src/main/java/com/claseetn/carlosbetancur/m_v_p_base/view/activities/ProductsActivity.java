package com.claseetn.carlosbetancur.m_v_p_base.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.claseetn.carlosbetancur.m_v_p_base.helper.Constants;
import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.presenter.ProductPresenter;
import com.claseetn.carlosbetancur.m_v_p_base.view.BaseActivity;
import com.claseetn.carlosbetancur.m_v_p_base.view.adapter.ProductAdapter;
import com.claseetn.carlosbetancur.m_v_p_base.R;

import java.util.ArrayList;

/**
 * Created by carlos andres betancur on 16/11/2017.
 */

public class ProductsActivity extends BaseActivity<ProductPresenter> implements IProductView {

    ListView       activity_product_list_view;
    ProductAdapter productAdapter            ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        setPresenter(new ProductPresenter());
        getPresenter().inject(this, getApplicationContext());
        getPresenter().getProductList();

        loadView();
    }

    private void loadView() {
        activity_product_list_view = (ListView) findViewById(R.id.activity_product_list_view);

    }

    @Override
    public void setProducts( final ArrayList<Product> products) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                callAdapter (products);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getProductList();
    }

    private void callAdapter(final ArrayList<Product> products) {
        productAdapter = new ProductAdapter(this, R.layout.layout_product_item, products);
        activity_product_list_view.setAdapter(productAdapter);
        activity_product_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProductsActivity.this, UpdateActivity.class);
                intent.putExtra(Constants.ITEM_PRODUCT, (Product) products.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(int correct) {

    }


}
