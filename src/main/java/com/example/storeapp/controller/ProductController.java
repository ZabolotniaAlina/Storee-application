package com.example.storeapp.controller;

import com.example.storeapp.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.storeapp.repository.ProductsUtils.availableProducts;


@RestController
@RequestMapping("/products")
public class ProductController {

//    public static List<Product> allProducts = new ArrayList<>();
//
//    static {
//        allProducts.add(new Product(1, "White shirt", 24, new BigDecimal(20.50)));
//        allProducts.add(new Product(2, "Blue sweater", 10, new BigDecimal(36.80)));
//        allProducts.add(new Product(3, "Black dress", 8, new BigDecimal(42.00)));
//    }


    @GetMapping("/all-products")
    public static List<Product> getAllProducts() {
        return availableProducts;
    }

    @GetMapping("/{productId}")
    public static Product getProductById(@PathVariable Integer productId) {

       return availableProducts.stream().filter(product -> product.getProductId() == productId).
                findAny().orElse(null);
//        for (Product p : availableProducts.values()) {
//            if (p.getProductId() == productId) {
//                return p;
//            }
//        }
//        return null;
    }

//    @PostMapping("/create-product")
//    public void createProduct(@RequestBody Product product) {
//        availableProducts.put(product.getProductId(), product);
//    }
//
//
//    @PutMapping("/update-product")
//    public void updateProduct(long productId) {
//        String query = "xxxx";
//        System.out.println("the query:" + query + "was processed!");
//    }


    @DeleteMapping("delete-product")
    public void deleteProduct(Integer productId) {

        availableProducts.removeIf(product -> product.getProductId() == productId);
//        for (Product p : getAllProducts()) {
//            if (p.getProductId() == productId) {
//                availableProducts.remove(p);
//            }
//        }
        System.out.println("Product was deleted");
    }
}
