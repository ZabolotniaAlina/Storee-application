package com.example.storeapp.service;

import com.example.storeapp.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import static com.example.storeapp.repository.ProductsUtils.availableProducts;

@Service
public class OrderService {
    public List<Product> checkoutOrder(List<Product> orderedProducts) {
        for (Product p1 : availableProducts) {
            for (Product p2 : orderedProducts) {
                if (p1.getProductId().equals(p2.getProductId()) && p1.getQuantity() >= p2.getQuantity()) {
                    p1.setQuantity(p1.getQuantity() - p2.getQuantity());
                } else if (p1.getProductId().equals(p2.getProductId()) && p1.getQuantity() < p2.getQuantity()) {
                    throw new RuntimeException("Sorry product" + p2.getTitle() + " is not available");
                }
            }
        }
        return orderedProducts;
    }

    public BigDecimal totalPrice(List<Product> cartProducts) {
        BigDecimal total = BigDecimal.ZERO;
        for (Product p : cartProducts) {
            BigDecimal quantityBD = BigDecimal.valueOf(p.getQuantity());
            total = total.add((p.getPrice().multiply(quantityBD)));
        }
        return total;
    }
}
