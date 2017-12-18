package com.claseetn.carlosbetancur.m_v_p_base.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos andres betancur on 21/11/2017.
 */

public class ProductAdapter extends ArrayAdapter {

    private ArrayList<Product> products;
    private Activity contexto;
    private int resource     ;
    private Product product  ;
    private TextView name    ;
    private TextView price   ;
    private TextView quantity;

    public ProductAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Product> products) {
        super(context, resource, products);
        this.contexto = (Activity) context;
        this.resource = resource;
        this.products = products;
    }


    @Override
    public int getCount() {
        if (products == null)
            return 0;
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_item, parent, false);

        this.product = this.products.get(position);

        loadView (view);

        name    .setText (product.getName    ());
        price   .setText (product.getPrice   ());
        quantity.setText (product.getQuantity());

        return view;
    }

    private void loadView(View view) {
        name     = (TextView) view.findViewById(R.id.product_item_name    );
        price    = (TextView) view.findViewById(R.id.product_item_price   );
        quantity = (TextView) view.findViewById(R.id.product_item_quantity);
    }

}
