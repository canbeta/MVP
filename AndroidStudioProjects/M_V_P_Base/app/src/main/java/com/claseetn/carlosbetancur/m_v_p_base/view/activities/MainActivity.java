package com.claseetn.carlosbetancur.m_v_p_base.view.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.claseetn.carlosbetancur.m_v_p_base.R;
import com.claseetn.carlosbetancur.m_v_p_base.presenter.MainPresenter;
import com.claseetn.carlosbetancur.m_v_p_base.view.BaseActivity;

/**
 * Created by pablo.garcia on 15/11/2017.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView, TextWatcher{

    EditText number1;
    EditText number2;
    TextView result;
    Button   btnSuma, btnResta, btnMultiplica, btnDivide, btnClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View -> Presenter
        setPresenter(new MainPresenter());
        getPresenter().inject(this, getApplicationContext());

        loadView();
    }

    @Override
    public void showAlertDialog(int id) {

    }

    @Override
    public void showAlertDialog(String message) {

    }

    @Override
    public void showToast(final int correct) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), getString(correct), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showResult(final long total) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                result.setText(String.valueOf(total));
            }
        });
    }

    public void loadView() {
        number1       = (EditText) findViewById(R.id.editTextNumber1);
        number2       = (EditText) findViewById(R.id.editTextNumber2);
        result        = (TextView) findViewById(R.id.textViewResult );
        btnSuma       = (Button)   findViewById(R.id.btnSuma        );
        btnResta      = (Button)   findViewById(R.id.btnResta       );
        btnDivide     = (Button)   findViewById(R.id.btnDivision    );
        btnMultiplica = (Button)   findViewById(R.id.btnMultiplica  );
        btnClean      = (Button)   findViewById(R.id.btnClean       );
        number1.addTextChangedListener(this);
        number2.addTextChangedListener(this);
    }

    public void sum(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().sum(n1,n2);
    }

    public void res(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().res(n1,n2);
    }

    public void division(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().div(n1,n2);
    }
    public void multiplication(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().mult(n1,n2);
    }
    public void clean(View view) {
        number1.setText("");
        number2.setText("");
        result.setText ("");

        btnSuma      .setEnabled(false);
        btnResta     .setEnabled(false);
        btnMultiplica.setEnabled(false);
        btnDivide    .setEnabled(false);
        btnClean     .setEnabled(false);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!("".equals(number1.getText().toString())) && !("".equals(number2.getText().toString()))){
            habilitarButton();
        }
        if (!("".equals(number1.getText().toString()))){
            btnClean.setEnabled(true);
        }
    }

    private void habilitarButton() {
        btnSuma      .setEnabled(true);
        btnResta     .setEnabled(true);
        btnMultiplica.setEnabled(true);
        btnDivide    .setEnabled(true);
        btnClean     .setEnabled(true);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
