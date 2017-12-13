package com.claseetn.carlosbetancur.m_v_p_base.presenter;

import com.claseetn.carlosbetancur.m_v_p_base.R;
import com.claseetn.carlosbetancur.m_v_p_base.model.repositories.IRepository;
import com.claseetn.carlosbetancur.m_v_p_base.model.repositories.Repository;
import com.claseetn.carlosbetancur.m_v_p_base.view.activities.IMainView;

/**
 * Created by pablo.garcia on 15/11/2017.
 */

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
                doSum(number1,number2);
            }
        });
        thread.start();
    }
    public void res(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doRes(number1,number2);
            }
        });
        thread.start();
    }

    public void div(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doDiv(number1,number2);
            }
        });
        thread.start();
    }

    public void mult(final String number1, final String number2) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doMult(number1,number2);
            }
        });
        thread.start();
    }

    private void doSum(String number1, String number2) {
        try {
            int total = Integer.valueOf(number1) + Integer.valueOf(number2);
            getView().showResult(total);
            // Presenter -> View
        }catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }
    private void doRes(String number1, String number2) {
        try {
            int total = Integer.valueOf(number1) - Integer.valueOf(number2);
            getView().showResult(total);
            // Presenter -> View
        }catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }

    private void doDiv(String number1, String number2) {
        try {
            if ("0".equals(number2)){
                getView().showToast(R.string.error_invalid_number_divide);
            }else {
                int total = Integer.valueOf(number1) / Integer.valueOf(number2);
                getView().showResult(total);
            }
            // Presenter -> View
        }catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }

    private void doMult(String number1, String number2) {
        try {
            int total = Integer.valueOf(number1) * Integer.valueOf(number2);
            getView().showResult(total);
            // Presenter -> View
        }catch (Exception e) {
            e.getMessage();
            getView().showToast(R.string.error_invalid_number);
        }
    }
}
