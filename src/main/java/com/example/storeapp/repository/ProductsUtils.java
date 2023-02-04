package com.example.storeapp.repository;

import com.example.storeapp.model.Order;
import com.example.storeapp.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ProductsUtils {

    public static List<Product> availableProducts = new ArrayList<>();

    static {
        availableProducts.add( new Product(1, "White shirt", 24, new BigDecimal(20.50)));
        availableProducts.add( new Product(2, "Blue sweater", 10, new BigDecimal(36.90)));
        availableProducts.add( new Product(3, "Black dress", 8, new BigDecimal(42.00)));
    }

    public static List<Order> totalOrders = new ArrayList<>();


}
