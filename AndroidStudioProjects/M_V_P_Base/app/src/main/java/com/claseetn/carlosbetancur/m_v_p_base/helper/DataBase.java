package com.claseetn.carlosbetancur.m_v_p_base.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.claseetn.carlosbetancur.m_v_p_base.dao.ProductDAOImpl;

/**
 * Created by carlos andres betancur on 12/12/2017.
 */

public class DataBase {

    public Context context;
    public DataBaseHelper dataBaseHelper;

    public static ProductDAOImpl dao;

    public DataBase(Context context) {
        this.context = context;
    }

    public DataBase open() throws SQLException{
        try{
            dataBaseHelper = new DataBaseHelper(context);
            SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
            dao = new ProductDAOImpl(db);
            return this;
        }catch (SQLException ex){
            Log.e("SQL Open: ", ex.getMessage());
            throw ex;
        }
    }

    public void close(){
        if(dataBaseHelper != null){
            dataBaseHelper.close();
        }
    }
}
