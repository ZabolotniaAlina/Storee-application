package com.example.storeapp.controller;

import com.example.storeapp.model.Cart;
import com.example.storeapp.model.Order;
import com.example.storeapp.model.Product;
import com.example.storeapp.model.Status;
import com.example.storeapp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.storeapp.repository.ProductsUtils.availableProducts;
import static com.example.storeapp.repository.ProductsUtils.totalOrders;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final OrderService orderService;
    public static List<Product> cartProducts = new ArrayList<>();

    private static Integer counter = 0;

    public CartController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/cart-content")
    public Cart getCartContent() {
        Cart cart = new Cart(cartProducts, orderService.totalPrice(cartProducts));
        return cart;
    }


    @PostMapping("/add-item")
    public String addItem(@RequestBody long productId, int quantity) {

        for (Product p : availableProducts) {
            if (p.getProductId() == productId) {
                p.setQuantity(quantity);
                cartProducts.add(p);
                return "This item was added to cart";
            }
        }
        return "This product wasn't added to cart";
    }

    @DeleteMapping("/remove-item")
    public void removeItem(@RequestBody long productId) {
        cartProducts.removeIf(product -> product.getProductId() == productId);
//        for (Product p : cartProducts) {
//            if (p.getProductId() == productId) {
//                cartProducts.remove(p);
//            }
//        }
        System.out.println("Product was removed");
    }

    @PutMapping("/update-item")
    public Product updateItem(@RequestBody long productId, int quantity) {

        cartProducts.stream().map(product -> {
            if (product.getProductId() == productId)
                product.setQuantity(quantity);
            return product;
        });
//        for (Product p : cartProducts) {
//            if (p.getProductId() == productId) {
//                p.setQuantity(quantity);
//   }
        return null;
//
    }

    @PostMapping("/order")
    public Order publishingAnOrder() {
        List<Product> products = orderService.checkoutOrder(cartProducts);
        Order order = new Order(++counter, LocalDate.now(), Status.SUBMITTED, orderService.totalPrice(cartProducts), products);
        totalOrders.add(order);
        return order;
    }
}



