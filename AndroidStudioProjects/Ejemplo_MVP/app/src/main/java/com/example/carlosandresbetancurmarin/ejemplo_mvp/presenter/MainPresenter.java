package com.example.carlosandresbetancurmarin.ejemplo_mvp.presenter;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.R;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.model.repositories.IRepository;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.model.repositories.Repository;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.activities.IMainView;


public class MainPresenter extends BasePresenter<IMainView> {

    private IRepository iRepository;

    public MainPresenter() {
        this.iRepository = new Repository();
    }

    public MainPresenter(IRepository iRepository) {
        this.iRepository = iRepository;
    }

    public void sum(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doSum(number1, number2);
            }
        });
        thread.start();
    }

    public void rest(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doRestar(number1, number2);
            }
        });
        thread.start();
    }
    public void multi(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doMulti(number1, number2);
            }
        });
        thread.start();
    }
    public void div(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doDiv(number1, number2);
            }
        });
        thread.start();
    }

    private void doSum(String number1, String number2) {
        try {
            int total = Integer.valueOf(number1) + Integer.valueOf(number2);
            getView().showResult(total);
            // Presenter -> View
        } catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }

    private void doRestar(String number1, String number2) {
        try {
            int total = Integer.valueOf(number1) - Integer.valueOf(number2);
            getView().showResult(total);
            // Presenter -> View
        } catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }
    private void doDiv (String number1, String number2) {
        try {
            if(Integer.parseInt(number2) == 0)
            getView().showToast(R.string.error_invalid_number);
            else {
                int total = Integer.valueOf(number1) / Integer.valueOf(number2);
                getView().showResult(total);
                // Presenter -> View
            }

        } catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }
    private void doMulti(String number1, String number2) {
        try {
            int total = Integer.valueOf(number1) * Integer.valueOf(number2);
            getView().showResult(total);
            // Presenter -> View
        } catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }
}

