package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.atech.data.fixture.CompanyData;
import br.com.atech.data.fixture.ProductData;

public class InvoiceTest {

    @Test
    public void testShouldCreateInvoice() {
        Company company = CompanyData.createCompanyApple();
        Product product = ProductData.createProductIphone6s();
        String customer = "John Doe";
        String description = "Invoice description";

        Invoice invoice = new Invoice(company, customer, description);
        invoice.addItem(product, 1);

        assertEquals(company, invoice.getCompany());
        assertEquals(customer, invoice.getCustomer());
        assertEquals(description, invoice.getDescription());
        assertEquals(BigDecimal.valueOf(2799), invoice.getTotalPrice());
    }
}
