package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.atech.data.fixture.ProductData;

public class ProductTest {

    @Test
    public void testShouldCreateProductAndReturnWithIdAndNameAndPrice() {
        Product product = ProductData.createProductIphone6s();

        assertEquals(1L, product.getId(), 0.1);
        assertEquals("iPhone 6S 16GB", product.getName());
        assertEquals(new BigDecimal(2799.00), product.getPrice());
    }
}
