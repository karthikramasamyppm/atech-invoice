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

import br.com.atech.entity.Product;
import br.com.atech.exception.ResourceNotFoundException;
import br.com.atech.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> index(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product show(@PathVariable Long id) {
        return productService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody @Valid final Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable Long id, @RequestBody @Valid final Product newProduct) {

        Product product = productService.findOneById(id);

        if (null == product) {
            throw new ResourceNotFoundException("Product not found");
        }

        newProduct.setId(id);

        return productService.save(newProduct);
    }
}
