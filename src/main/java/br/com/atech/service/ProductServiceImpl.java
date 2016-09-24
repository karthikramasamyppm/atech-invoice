package br.com.atech.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.atech.entity.Product;
import br.com.atech.jms.ProductCreateProducer;
import br.com.atech.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private final ProductCreateProducer producer;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ProductCreateProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Product findOneById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void saveAsync(Product product) {
        producer.send(product);
    }
}
