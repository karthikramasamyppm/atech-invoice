package br.com.atech.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.atech.entity.Company;
import br.com.atech.repository.CompanyRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Company> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Company findOneById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Company save(Company company) {
        return repository.save(company);
    }
}
