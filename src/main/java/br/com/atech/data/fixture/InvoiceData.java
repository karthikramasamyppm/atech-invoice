package br.com.atech.data.fixture;

import br.com.atech.entity.Company;
import br.com.atech.entity.Invoice;
import br.com.atech.entity.Product;

public class InvoiceData {

    public static Invoice createInvoiceForAppleWithOneProduct() {
        Company company = CompanyData.createCompanyApple();

        Invoice invoice = new Invoice(company, "John Doe", "Invoice description");

        Product product = ProductData.createProductIphone6s();
        invoice.addItem(product, 1);

        return invoice;
    }

    public static Invoice createInvoiceForAppleWithTwoProducts() {
        Company company = CompanyData.createCompanyApple();

        Invoice invoice = new Invoice(company, "Joe Bloggs", "Invoice description");
        invoice.addItem(ProductData.createProductIphone6s(), 1);
        invoice.addItem(ProductData.createProductIpadMini(), 1);

        return invoice;
    }

    public static Invoice createInvoiceForMotorolaWithOneProductAndTwoUnits() {
        Company company = CompanyData.createCompanyMotorola();

        Invoice invoice = new Invoice(company, "Alice Atkins", "Invoice description");

        Product product = ProductData.createProductMotoX();
        invoice.addItem(product, 2);

        return invoice;
    }

    public static Invoice createInvoiceForSamsungWithOneProduct() {
        Company company = CompanyData.createCompanySamsung();

        Invoice invoice = new Invoice(company, "Jane Roe", "Invoice description");

        Product product = ProductData.createProductGalaxyS6();
        invoice.addItem(product, 1);

        return invoice;
    }
}
