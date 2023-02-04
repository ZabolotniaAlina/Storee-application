package com.example.storeapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {


    private Integer orderId;

    private LocalDate dateCreated;

    private Status status;


    private BigDecimal totalPrice;

    private List<Product> orderedProducts;


    public Order(Integer orderId, LocalDate dateCreated, Status status, BigDecimal totalPrice, List<Product> orderedProducts) {
        this.orderId = orderId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderedProducts = orderedProducts;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
}
