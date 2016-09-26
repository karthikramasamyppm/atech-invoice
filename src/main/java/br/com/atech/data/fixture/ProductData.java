package br.com.atech.data.fixture;

import java.math.BigDecimal;

import br.com.atech.entity.Product;

public class ProductData {

    public static Product createProductIphone6s() {
        return new Product(1L, "iPhone 6S 16GB", new BigDecimal(2799.00));
    }

    public static Product createProductIpadMini() {
        return new Product(2L, "iPad Mini 64GB", new BigDecimal(3700.00));
    }

    public static Product createProductMotoX() {
        return new Product(3L, "Moto X Style 32GB", new BigDecimal(2199.00));
    }

    public static Product createProductGalaxyS6() {
        return new Product(4L, "Galaxy S6", new BigDecimal(1799.00));
    }
}
