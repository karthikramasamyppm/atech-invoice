package br.com.atech.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.atech.entity.Company;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}
