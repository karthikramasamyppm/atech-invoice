package br.com.atech.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne(targetEntity = Invoice.class)
    private Invoice invoice;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
    private Integer quantity;

    public InvoiceItem() {
    }

    public InvoiceItem(Invoice invoice, Product product, Integer quantity) {
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public InvoiceItem setId(Long id) {
        this.id = id;

        return this;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public InvoiceItem setInvoice(Invoice invoice) {
        this.invoice = invoice;

        return this;
    }

    public Product getProduct() {
        return product;
    }

    public InvoiceItem setProduct(Product product) {
        this.product = product;

        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public InvoiceItem setQuantity(Integer quantity) {
        this.quantity = quantity;

        return this;
    }

    @Transient
    public BigDecimal getTotalPrice() {
        return getProduct().getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }
}
