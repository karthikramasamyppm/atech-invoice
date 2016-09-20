package br.com.atech.entity;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Long id;
    private Company company;
    private String customer;
    private String description;
    private List<InvoiceItem> items = new ArrayList<InvoiceItem>();

    public Invoice() {
        super();
    }

    public Invoice(Long id, Company company, String customer, String description, List<InvoiceItem> items) {
        super();
        this.id = id;
        this.company = company;
        this.customer = customer;
        this.description = description;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
}
