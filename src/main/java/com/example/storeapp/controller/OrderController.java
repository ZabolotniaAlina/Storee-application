package com.example.storeapp.controller;


import com.example.storeapp.model.Order;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.storeapp.repository.ProductsUtils.availableProducts;
import static com.example.storeapp.repository.ProductsUtils.totalOrders;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/showOrders")
    public List<Order> allOrders() {
        return totalOrders;
    }

    @DeleteMapping("/cancelOrder")
    public String deleteOrder(Integer orderId) {
//        totalOrders.stream().map(order -> {
//            if (order.getOrderId().equals(orderId))
//                totalOrders.remove(order);
//            order.getOrderedProducts().get(orderId).setQuantity(availableProducts.get(orderId).getQuantity() + order.getOrderedProducts().get(orderId).getQuantity());
//        return "Order was canceled";
//        });
        for (Order o : allOrders()) {
            if (o.getOrderId() == orderId) {
                totalOrders.remove(o);
                o.getOrderedProducts().get(orderId).setQuantity(availableProducts.get(orderId).getQuantity() + o.getOrderedProducts().get(orderId).getQuantity());
            }
            return "Order was canceled!";
        }
        return "Order wasn't canceled!";
    }
}

