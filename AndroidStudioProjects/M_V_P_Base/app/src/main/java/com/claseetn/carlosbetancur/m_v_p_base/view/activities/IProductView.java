package com.claseetn.carlosbetancur.m_v_p_base.view.activities;

import com.claseetn.carlosbetancur.m_v_p_base.dto.Product;
import com.claseetn.carlosbetancur.m_v_p_base.view.IBaseView;

import java.util.ArrayList;

/**
 * Created by pablo.garcia on 21/11/2017.
 */

public interface IProductView extends IBaseView{

    public void setProducts(ArrayList<Product> products);

    void showToast(int error_invalid_number);
}
