package com.example.carlosandresbetancurmarin.ejemplo_mvp.presenter;

import android.content.Context;

import com.example.carlosandresbetancurmarin.ejemplo_mvp.helper.IvalidateInternet;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.helper.ValidateInternet;
import com.example.carlosandresbetancurmarin.ejemplo_mvp.view.IBaseView;


public class BasePresenter<T extends IBaseView> {

    private T view;

    public IvalidateInternet getValidateInternet() {
        return validateInternet;
    }

    private IvalidateInternet validateInternet;

    public void inject(T view, Context context) {
        this.view = view;
        validateInternet = new ValidateInternet(context);
    }

    public T getView() {
        return view;
    }


}
