package br.com.atech.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.atech.data.fixture.CompanyData;

public class CompanyTest {

    @Test
    public void testShouldCreateCompanyAndReturnWithIdAndName() {
        Company company = CompanyData.createCompanyApple();

        assertEquals(1L, company.getId(), 0.1);
        assertEquals("Apple", company.getName());
    }
}
