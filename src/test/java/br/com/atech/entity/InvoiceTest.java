package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class InvoiceTest {

    @Test
    public void testShouldCreateInvoice() {
        Company company = new Company(1L, "Apple");
        Product product = new Product(1L, "iPhone 6S 16GB", new BigDecimal(2799.00));
        String customer = "John Doe";
        String description = "Invoice description";

        Invoice invoice = new Invoice(company, customer, description);
        invoice.addItem(product, 1);

        assertEquals(company, invoice.getCompany());
        assertEquals(customer, invoice.getCustomer());
        assertEquals(description, invoice.getDescription());
    }
}
