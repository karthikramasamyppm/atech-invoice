package br.com.atech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;

        return this;
    }
}
