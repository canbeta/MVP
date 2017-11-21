package com.example.carlosandresbetancurmarin.ejemplo_mvp.view.activities;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.IBaseView;



public interface IMainView extends IBaseView {

    public void showAlertDialog(int id);
    public void showAlertDialog(String message);
    public void showToast(int correct);
    public void showResult(final long total);
}
