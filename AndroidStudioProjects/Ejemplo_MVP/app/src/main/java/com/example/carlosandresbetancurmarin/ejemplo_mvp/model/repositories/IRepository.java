package com.example.carlosandresbetancurmarin.ejemplo_mvp.model.repositories;


import com.example.carlosandresbetancurmarin.ejemplo_mvp.dto.Product;

import java.util.ArrayList;

public interface IRepository {
    ArrayList<Product> getProducts();
}
