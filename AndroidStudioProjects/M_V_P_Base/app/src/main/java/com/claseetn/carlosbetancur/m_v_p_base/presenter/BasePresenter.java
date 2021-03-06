package com.claseetn.carlosbetancur.m_v_p_base.presenter;

import android.content.Context;

import com.claseetn.carlosbetancur.m_v_p_base.helper.IValidateInternet;
import com.claseetn.carlosbetancur.m_v_p_base.helper.ValidateInternet;
import com.claseetn.carlosbetancur.m_v_p_base.view.IBaseView;

/**
 * Created by carlos andres betancuron 15/11/2017.
 */

public class BasePresenter<T extends IBaseView> {

    private T view;

    private IValidateInternet validateInternet;

    public void inject(T view, Context context) {
        this.view = view;
        validateInternet = new ValidateInternet(context);
    }

    public T getView() {
        return view;
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }
}
