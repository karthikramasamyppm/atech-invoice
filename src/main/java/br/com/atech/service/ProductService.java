package br.com.atech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.atech.entity.Product;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Product findOneById(Long id);

    Product save(Product product);
}
