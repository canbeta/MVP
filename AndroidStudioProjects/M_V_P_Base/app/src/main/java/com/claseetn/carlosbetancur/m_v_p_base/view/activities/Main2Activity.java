package com.claseetn.carlosbetancur.m_v_p_base.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.claseetn.carlosbetancur.m_v_p_base.R;
import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.presenter.InsertProductPresenter;
import com.claseetn.carlosbetancur.m_v_p_base.presenter.ProductPresenter;
import com.claseetn.carlosbetancur.m_v_p_base.view.BaseActivity;

public class Main2Activity extends BaseActivity<InsertProductPresenter> implements IInsertProductView {

    EditText txtName    ;
    EditText txtPrice   ;
    EditText txtQuantity;

    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setPresenter(new InsertProductPresenter());
        getPresenter().inject(this, getApplicationContext());

        loadView();
    }

    public void loadView() {
        txtName     = (EditText) findViewById(R.id.txt_name    );
        txtPrice    = (EditText) findViewById(R.id.txt_price   );
        txtQuantity = (EditText) findViewById(R.id.txt_quantity);
        btnInsert   = (Button)   findViewById(R.id.btn_insert  );
    }

    @Override
    public void showResult() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Main2Activity.this, getString(R.string.ok_message), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void doInsert(View view) {

        Product product = new Product();
        product.setName(txtName.getText().toString());
        product.setPrice(txtPrice.getText().toString());
        product.setQuantity(txtQuantity.getText().toString());
        product.setDescription(txtName.getText().toString());
        getPresenter().insertProduct(product);


    }
}
