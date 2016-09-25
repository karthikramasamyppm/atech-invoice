package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class InvoiceItemTest {

    @Test
    public void testShouldCreateInvoiceItemAndReturWithInvoiceAndProductAndQuantity() {
        Invoice invoice = new Invoice();
        Product product = new Product(1L, "iPhone 6S 16GB", new BigDecimal(2799.00));

        InvoiceItem item = new InvoiceItem(invoice, product, 1);

        assertEquals(invoice, item.getInvoice());
        assertEquals(product, item.getProduct());
        assertEquals(1, item.getQuantity(), 0.1);
    }
}
