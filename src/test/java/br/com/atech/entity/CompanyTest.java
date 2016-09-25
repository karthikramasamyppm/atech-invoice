package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompanyTest {

    @Test
    public void testShouldCreateCompanyAndReturnWithIdAndName() {
        Company company = new Company(1L, "Apple");

        assertEquals(1L, company.getId(), 0.1);
        assertEquals("Apple", company.getName());
    }
}
