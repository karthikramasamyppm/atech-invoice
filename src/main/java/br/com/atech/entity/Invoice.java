package br.com.atech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Company company;
    private String customer;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceItem> items = new ArrayList<InvoiceItem>();

    public Invoice() {
    }

    public Invoice(Company company, String customer, String description, List<InvoiceItem> items) {
        this.company = company;
        this.customer = customer;
        this.description = description;
        this.items = items;
    }

    public Invoice(Company company, String customer, String description) {
        this.company = company;
        this.customer = customer;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Invoice setId(Long id) {
        this.id = id;

        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Invoice setCompany(Company company) {
        this.company = company;

        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Invoice setCustomer(String customer) {
        this.customer = customer;

        return this;
    }

    public String getDescription() {
        return description;
    }

    public Invoice setDescription(String description) {
        this.description = description;

        return this;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public Invoice setItems(List<InvoiceItem> items) {
        this.items = items;

        return this;
    }

    public Invoice addItem(InvoiceItem item) {
        this.items.add(item);

        return this;
    }
}
