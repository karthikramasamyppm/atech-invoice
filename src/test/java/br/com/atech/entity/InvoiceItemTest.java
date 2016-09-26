package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.atech.data.fixture.ProductData;

public class InvoiceItemTest {

    @Test
    public void testShouldCreateInvoiceItemAndReturWithInvoiceAndProductAndQuantity() {
        Invoice invoice = new Invoice();
        Product product = ProductData.createProductIphone6s();

        InvoiceItem item = new InvoiceItem(invoice, product, 1);

        assertEquals(invoice, item.getInvoice());
        assertEquals(product, item.getProduct());
        assertEquals(1, item.getQuantity(), 0.1);
        assertEquals(BigDecimal.valueOf(2799), item.getTotalPrice());
    }
}
