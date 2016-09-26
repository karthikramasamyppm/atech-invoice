package br.com.atech.data.helper;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atech.data.fixture.CompanyData;
import br.com.atech.data.fixture.InvoiceData;
import br.com.atech.data.fixture.ProductData;
import br.com.atech.entity.Company;
import br.com.atech.entity.Invoice;
import br.com.atech.entity.Product;
import br.com.atech.repository.CompanyRepository;
import br.com.atech.repository.InvoiceRepository;
import br.com.atech.repository.ProductRepository;

@Service
@Transactional
public class DataHelper {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void setup() {
        // Companies
        Company companyApple = CompanyData.createCompanyApple();
        Company companyMotorola = CompanyData.createCompanyMotorola();
        Company companySamsung = CompanyData.createCompanySamsung();

        companyRepository.save(companyApple);
        companyRepository.save(companyMotorola);
        companyRepository.save(companySamsung);

        // Products
        Product productIphone6 = ProductData.createProductIphone6s();
        Product productIpadMini = ProductData.createProductIpadMini();
        Product productMotoX = ProductData.createProductMotoX();
        Product productGalaxyS6 = ProductData.createProductGalaxyS6();

        productRepository.save(productIphone6);
        productRepository.save(productIpadMini);
        productRepository.save(productMotoX);
        productRepository.save(productGalaxyS6);

        // Invoices
        Invoice invoiceApple = InvoiceData.createInvoiceForAppleWithTwoProducts();
        Invoice invoiceMotorola = InvoiceData.createInvoiceForMotorolaWithOneProductAndTwoUnits();
        Invoice invoiceSamsung = InvoiceData.createInvoiceForSamsungWithOneProduct();

        invoiceRepository.save(invoiceApple);
        invoiceRepository.save(invoiceMotorola);
        invoiceRepository.save(invoiceSamsung);
    }
}
