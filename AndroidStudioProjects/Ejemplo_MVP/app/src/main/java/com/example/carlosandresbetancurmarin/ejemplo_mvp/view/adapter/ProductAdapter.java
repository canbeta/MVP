package com.example.carlosandresbetancurmarin.ejemplo_mvp.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.R;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.dto.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlosandresbetancurmarin on 21/11/17.
 */

public class ProductAdapter extends ArrayAdapter {


    private ArrayList<Product> products;
    private Activity contexto;
    private int resource;
    private Product product;
    private TextView name;
    private TextView price;
    private TextView quantity;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> products) {
        super(context, resource, products);
        this.contexto = (Activity) context;
        this.resource = resource;
        this.products = products;


    }


    @Override
    public int getCount() {
        if (products == null) {
            return 0;

        }
        return products.size();
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_item,parent,false);
        this.product=this.products.get(position);
        loadView(view);
        name.setText(product.getPrice());
        price.setText(product.getPrice());
        quantity.setText(product.getQuantity());
        return view;
    }

    private void loadView(View view) {
        name = view.findViewById(R.id.product_item_name);
        price = view.findViewById(R.id.product_item_valor);
        quantity = view.findViewById(R.id.product_item_cantidad);
    }
}
