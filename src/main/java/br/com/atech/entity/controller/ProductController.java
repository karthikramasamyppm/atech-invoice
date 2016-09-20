package br.com.atech.entity.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atech.entity.Product;

@RestController
public class ProductController {

    @RequestMapping("/products")
    public List<Product> index() {

        Product p1 = new Product(1L, "iPhone", new BigDecimal("2359.00"));
        Product p2 = new Product(2L, "iPad", new BigDecimal("2400.00"));

        return Arrays.asList(p1, p2);
    }
}
