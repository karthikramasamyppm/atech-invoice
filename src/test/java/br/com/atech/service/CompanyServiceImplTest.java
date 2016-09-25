package br.com.atech.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.atech.entity.Company;
import br.com.atech.repository.CompanyRepository;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    private CompanyService companyService;

    @Before
    public void setUp() {
        companyService = new CompanyServiceImpl(companyRepository);
    }

    @Test
    public void testShouldReturnAValidCompanyWhenfindOneByIdIsCalledWithAValidId() {
        final Company expectedCompany = stubServiceToReturnValidCompany();

        Company returnedCompany = companyService.findOneById(1L);

        verify(companyRepository, times(1)).findOne(1L);
        assertEquals("Should return a valid company", expectedCompany, returnedCompany);
    }

    @Test
    public void testShouldReturnAllCompanies() {
        final Page<Company> expectedCompanies = stubServiceToReturnValidCompanies();

        final Pageable pageRequest = new PageRequest(0, 10, Sort.Direction.ASC, "id");

        Page<Company> returnedCompanies = companyService.findAll(pageRequest);

        verify(companyRepository, times(1)).findAll(pageRequest);
        assertEquals("Should return a list of company", expectedCompanies, returnedCompanies);
        assertEquals(expectedCompanies.getTotalElements(), returnedCompanies.getTotalElements());
    }

    @Test
    public void testShouldCreateCompany() throws Exception {
        final Company expectedCompany = stubServiceToReturnStoredCompany();
        final Company company = new Company();

        Company returnedCompany = companyService.save(company);

        verify(companyRepository, times(1)).save(company);
        assertEquals("Should create a company", expectedCompany, returnedCompany);
    }

    private Company stubServiceToReturnValidCompany() {
        final Company company = new Company();

        when(companyRepository.findOne(any(Long.class))).thenReturn(company);

        return company;
    }

    private Page<Company> stubServiceToReturnValidCompanies() {
        final Company firstCompany = new Company(1L, "Foo");
        final Company secondCompany = new Company(2L, "Bar");

        final List<Company> companies = Arrays.asList(firstCompany, secondCompany);
        final Page<Company> expectedCompanies = new PageImpl<>(companies);

        when(companyRepository.findAll(any(Pageable.class))).thenReturn(expectedCompanies);

        return expectedCompanies;
    }

    private Company stubServiceToReturnStoredCompany() {
        final Company company = new Company();

        when(companyRepository.save(any(Company.class))).thenReturn(company);

        return company;
    }
}
