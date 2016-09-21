package br.com.atech.repository.filter;

public class InvoiceSearchFilter {
    private Long companyId;
    private Long productId;
    private String productName;

    public InvoiceSearchFilter() {
    }

    public InvoiceSearchFilter(Long companyId, Long productId, String productName) {
        this.companyId = companyId;
        this.productId = productId;
        this.productName = productName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public InvoiceSearchFilter setCompanyId(Long companyId) {
        this.companyId = companyId;

        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public InvoiceSearchFilter setProductId(Long productId) {
        this.productId = productId;

        return this;
    }

    public String getProductName() {
        return productName;
    }

    public InvoiceSearchFilter setProductName(String productName) {
        this.productName = productName;

        return this;
    }
}
