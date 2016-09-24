package br.com.atech.entity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.atech.entity.Company;
import br.com.atech.exception.ResourceNotFoundException;
import br.com.atech.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController extends ApiController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Company> index(Pageable pageable) {
        return companyService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company show(@PathVariable Long id) {
        Company company = companyService.findOneById(id);

        if (null == company) {
            throw new ResourceNotFoundException("Company not found");
        }

        return company;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Company create(@RequestBody @Valid final Company company) {
        return companyService.save(company);
    }
}
