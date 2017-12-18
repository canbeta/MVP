package com.claseetn.carlosbetancur.m_v_p_base.shemes;

/**
 * Created by carlos andres betancur on 12/12/2017.
 */

public interface IProductScheme {

    String PRODUCT_TABLE                    = "products"   ;
    String PRODUCT_TABLE_COLUMN_ID          = "_id"        ;
    String PRODUCT_TABLE_COLUMN_NAME        = "name"       ;
    String PRODUCT_TABLE_COLUMN_DESCRIPTION = "description";
    String PRODUCT_TABLE_COLUMN_PRICE       = "price"      ;
    String PRODUCT_TABLE_COLUMN_QUANTITY    = "quantity"   ;

    String [] PRODUCT_COLUMNS = new String[]{
            PRODUCT_TABLE_COLUMN_ID, PRODUCT_TABLE_COLUMN_NAME, PRODUCT_TABLE_COLUMN_DESCRIPTION, PRODUCT_TABLE_COLUMN_PRICE, PRODUCT_TABLE_COLUMN_QUANTITY
    };

    String PRODUCT_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS "+ PRODUCT_TABLE +
                    " ( "+
                        PRODUCT_TABLE_COLUMN_ID          + " TEXT PRIMARY KEY, "     +
                        PRODUCT_TABLE_COLUMN_NAME        + " TEXT UNIQUE NOT NULL, " +
                        PRODUCT_TABLE_COLUMN_DESCRIPTION + " TEXT, "                 +
                        PRODUCT_TABLE_COLUMN_PRICE       + " TEXT "                  +
                        PRODUCT_TABLE_COLUMN_QUANTITY    + " TEXT "                  +
                    " ); ";

    String PRODUCT_TABLE_DROP = "DROP TABLE IF EXISTS " + PRODUCT_TABLE;
}
