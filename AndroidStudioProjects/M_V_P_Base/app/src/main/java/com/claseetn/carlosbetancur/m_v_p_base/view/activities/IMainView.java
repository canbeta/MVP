package com.claseetn.carlosbetancur.m_v_p_base.view.activities;

import com.claseetn.carlosbetancur.m_v_p_base.view.IBaseView;

/**
 * Created by carlos andres betancur on 15/11/2017.
 */

public interface IMainView extends IBaseView {

    public void showAlertDialog(int id);
    public void showAlertDialog(String message);
    public void showToast(int correct);
    public void showResult(final long total);
}
