package com.claseetn.carlosbetancur.m_v_p_base.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.claseetn.carlosbetancur.m_v_p_base.presenter.BasePresenter;

/**
 * Created by carlos andres betancur on 15/11/2017.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private ProgressDialog progressDialog;
    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createProgress();
    }

    @Override
    public void showProgress(int message) {
        progressDialog.setMessage(getResources().getString(message));
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showToast(int error_invalid_number) {

    }

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    public void createProgress() {
        this.progressDialog = new ProgressDialog(this);
    }
}
