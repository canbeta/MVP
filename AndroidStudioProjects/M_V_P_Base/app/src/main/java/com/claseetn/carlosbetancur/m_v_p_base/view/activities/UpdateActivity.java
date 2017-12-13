package com.claseetn.carlosbetancur.m_v_p_base.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.claseetn.carlosbetancur.m_v_p_base.R;
import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.helper.Constants;
import com.claseetn.carlosbetancur.m_v_p_base.presenter.UpdateProductPresenter;
import com.claseetn.carlosbetancur.m_v_p_base.view.BaseActivity;

public class UpdateActivity extends BaseActivity<UpdateProductPresenter> implements IUpdateProducView {

    EditText txtIde;
    EditText txtName;
    EditText txtPrice;
    EditText txtQuantity;

    Button btnInsert, btnUpdate, btnDelete;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        setPresenter(new UpdateProductPresenter());
        product = (Product)getIntent().getSerializableExtra(Constants.ITEM_PRODUCT);
        
        getPresenter().inject(this, getApplicationContext());

        loadView();
        loadData();
    }

    private void loadData() {
        txtIde.setText(product.getId());
        txtName.setText(product.getName());
        txtPrice.setText(product.getPrice());
        txtQuantity.setText(product.getQuantity());

    }

    public void loadView() {
        txtIde      = (EditText) findViewById(R.id.txt_id      );
        txtName     = (EditText) findViewById(R.id.txt_name    );
        txtPrice    = (EditText) findViewById(R.id.txt_price   );
        txtQuantity = (EditText) findViewById(R.id.txt_quantity);
        btnInsert   = (Button)   findViewById(R.id.btn_insert  );
        btnUpdate   = (Button)   findViewById(R.id.btn_update  );
        btnDelete   = (Button)   findViewById(R.id.btn_delete  );

    }

    public void doInsert (View view){
        Intent intent = new Intent(UpdateActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void doUpdate (View view){
        Product product = new Product();
        product.setId(txtIde.getText().toString());
        product.setName(txtName.getText().toString());
        product.setPrice(txtPrice.getText().toString());
        product.setQuantity(txtQuantity.getText().toString());
        product.setDescription(txtName.getText().toString());
        getPresenter().updateProduct(product);
    }

    public void doDelete (View view){
        Product product = new Product();
        product.setId(txtIde.getText().toString());
        /*product.setName(txtName.getText().toString());
        product.setPrice(txtPrice.getText().toString());
        product.setQuantity(txtQuantity.getText().toString());
        product.setDescription(txtName.getText().toString());*/
        getPresenter().deleteProduct(product);
    }


    @Override
    public void showResult() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(UpdateActivity.this, getString(R.string.ok_message), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
