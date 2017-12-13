package com.claseetn.carlosbetancur.m_v_p_base.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pablo.garcia on 21/11/2017.
 */

public class Product implements Serializable{

    @SerializedName("name")
    @Expose
    private String name    ;
    @SerializedName("price")
    @Expose
    private String price   ;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
