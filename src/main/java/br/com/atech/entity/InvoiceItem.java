package br.com.atech.entity;

public class InvoiceItem {
    private Long id;
    private Invoice invoice;
    private Product product;
    private Integer quantity;

    public InvoiceItem() {
        super();
    }

    public InvoiceItem(Long id, Invoice invoice, Product product, Integer quantity) {
        super();
        this.id = id;
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
