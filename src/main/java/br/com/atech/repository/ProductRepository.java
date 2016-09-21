package br.com.atech.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.atech.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
