package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductTest {

    @Test
    public void testShouldCreateProductAndReturnWithIdAndNameAndPrice() {
        Long id = 1L;
        String name = "iPhone 6S 16GB";
        BigDecimal price = new BigDecimal(2799.00);

        Product product = new Product(id, name, price);

        assertEquals(id, product.getId(), 0.1);
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
    }
}
