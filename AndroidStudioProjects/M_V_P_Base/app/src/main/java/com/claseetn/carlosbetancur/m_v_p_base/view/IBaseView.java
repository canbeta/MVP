package com.claseetn.carlosbetancur.m_v_p_base.view;

/**
 * Created by pablo.garcia on 15/11/2017.
 */

public interface IBaseView {

    public void showProgress(int message);
    public void hideProgress();

    void showToast(int error_invalid_number);
}
