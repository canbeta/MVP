package com.example.carlosandresbetancurmarin.ejemplo_mvp.view.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.R;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.presenter.MainPresenter;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.BaseActivity;

/**
 * Al crear un Activity debemos especificarle cual va a ser su BaseActivity, su Presentador y
 * la plantilla de la vista
 */
public class MainActivity extends BaseActivity<MainPresenter> implements IMainView , TextWatcher{

    EditText number1;
    EditText number2;
    TextView result;
    Button btnResta;
    Button btnSum;
    Button btnDiv;
    Button btnMult;

    public boolean habilitaBtn;


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
        number1 = findViewById(R.id.editTextNumber1);
        number2 = findViewById(R.id.editTextNumber2);
        result = findViewById(R.id.textViewResult);
        btnSum = findViewById(R.id.buttonSum);
        btnDiv = findViewById(R.id.buttonDiv);
        btnResta = findViewById(R.id.buttonResta);
        btnMult = findViewById(R.id.buttonMult);
        number1.addTextChangedListener(this);
        number2.addTextChangedListener(this);


        //getPresenter().sum("1","2");
    }

    private void habilitarBotones() {
        btnResta.setEnabled(true);
        btnSum.setEnabled(true);
        btnMult.setEnabled(true);
        btnDiv.setEnabled(true);
    }

    public void sum(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().sum(n1, n2);
    }

    public void rest(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().rest(n1, n2);
    }

    public void div(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().div(n1, n2);
    }


    public void mult(View view) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();
        getPresenter().multi(n1, n2);
    }

    public void Limp(View view) {
        number1.setText("");
        number2.setText("");
        result.setText("");
        btnResta.setEnabled(false);
        btnSum.setEnabled(false);
        btnDiv.setEnabled(false);
        btnMult.setEnabled(false);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        Log.i("TEST", number1.getText().toString());
//        Log.i("TEST", number2.getText().toString());
        if (!("".equals(number1.getText().toString())) && !("".equals(number2.getText().toString()))){
            //Log.i("TEST", "Habilitar...");
            habilitarBotones();
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
