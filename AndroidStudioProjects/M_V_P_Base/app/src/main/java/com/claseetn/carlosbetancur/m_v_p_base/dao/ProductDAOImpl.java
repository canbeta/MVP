package com.claseetn.carlosbetancur.m_v_p_base.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;


import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.providers.DbContentProvider;
import com.claseetn.carlosbetancur.m_v_p_base.shemes.IProductScheme;

import java.util.ArrayList;

/**
 * Created by carlos andres betancur on 12/12/2017.
 */

public class ProductDAOImpl extends DbContentProvider implements IProductDAO, IProductScheme {

    private Cursor cursor;
    private ContentValues contentValues;


    public ProductDAOImpl (SQLiteDatabase db){
        super(db);
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<Product>();
        super.query(PRODUCT_TABLE, PRODUCT_COLUMNS, null, null, PRODUCT_TABLE_COLUMN_NAME);
        if (cursor!= null){
            cursor.moveToFirst();
            while (cursor!= null && !cursor.isAfterLast()){
                Product product = cursorToEntity(cursor);
                productList.add(product);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return productList;
    }

    @Override
    public boolean insertProduct(Product product) {
        boolean response = false;
        long rowId = 0;
        try{
            setContentValues(product);
            rowId = super.insert(PRODUCT_TABLE, getContentValues());
            if (rowId>-1){
                response = true;
            }
        }catch (SQLiteException ex){
            Log.e("DbErrorCreateProduct", ex.getMessage());
        }
        return response;
    }


    private ContentValues getContentValues(){
        return contentValues;
    }

    private void setContentValues(Product product) {
        this.contentValues = new ContentValues();
        this.contentValues.put(PRODUCT_TABLE_COLUMN_ID, product.getId());
        this.contentValues.put(PRODUCT_TABLE_COLUMN_NAME, product.getName());
        this.contentValues.put(PRODUCT_TABLE_COLUMN_DESCRIPTION, product.getDescription());
        this.contentValues.put(PRODUCT_TABLE_COLUMN_PRICE, product.getPrice());
        this.contentValues.put(PRODUCT_TABLE_COLUMN_QUANTITY, product.getQuantity());
    }

    @Override
    public boolean deleteProduct(Product product) {
        try {
            String selection = PRODUCT_TABLE_COLUMN_ID + " = ?";
            String[] selectionArgs = { product.getId() };
            return super.delete(PRODUCT_TABLE, selection, selectionArgs) > 0;
        }catch (SQLiteConstraintException ex){
            Log.e("DBErrorDeleteProduct", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateProduct (Product product) {
        setContentValues(product);
        try{
            String selection = PRODUCT_TABLE_COLUMN_ID + " = ?";
            String[] selectionArgs = { product.getId() };
            return super.update(PRODUCT_TABLE, getContentValues(), selection, selectionArgs) > 0;
        }catch (SQLiteConstraintException ex){
            Log.e("DBErrorUpdateProduct", ex.getMessage());
            return false;
        }
    }
    @Override
    protected  Product cursorToEntity(Cursor cursor){
        Product product = new Product();
        int index;
        if (cursor.getColumnIndex(PRODUCT_TABLE_COLUMN_ID)> -1){
            index = cursor.getColumnIndexOrThrow(PRODUCT_TABLE_COLUMN_ID);
            product.setId(cursor.getString(index));
        }
        if (cursor.getColumnIndex(PRODUCT_TABLE_COLUMN_NAME)> -1){
            index = cursor.getColumnIndexOrThrow(PRODUCT_TABLE_COLUMN_NAME);
            product.setName(cursor.getString(index));
        }
        if (cursor.getColumnIndex(PRODUCT_TABLE_COLUMN_DESCRIPTION)> -1){
            index = cursor.getColumnIndexOrThrow(PRODUCT_TABLE_COLUMN_DESCRIPTION);
            product.setDescription(cursor.getString(index));
        }
        if (cursor.getColumnIndex(PRODUCT_TABLE_COLUMN_PRICE)> -1){
            index = cursor.getColumnIndexOrThrow(PRODUCT_TABLE_COLUMN_PRICE);
            product.setPrice(cursor.getString(index));
        }
        if (cursor.getColumnIndex(PRODUCT_TABLE_COLUMN_QUANTITY)> -1){
            index = cursor.getColumnIndexOrThrow(PRODUCT_TABLE_COLUMN_QUANTITY);
            product.setQuantity(cursor.getString(index));
        }
        return product;
    }
}
