package br.com.atech.data.fixture;

import br.com.atech.entity.Company;

public class CompanyData {

    public static Company createCompanyApple() {
        return new Company(1L, "Apple");
    }

    public static Company createCompanyMotorola() {
        return new Company(2L, "Motorola");
    }

    public static Company createCompanySamsung() {
        return new Company(3L, "Samsung");
    }
}
