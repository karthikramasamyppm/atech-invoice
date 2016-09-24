package br.com.atech.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.atech.entity.Product;
import br.com.atech.service.ProductService;

@Component
public class ProductCreateConsumer {

    private final ProductService productService;

    @Autowired
    public ProductCreateConsumer(ProductService productService) {
        this.productService = productService;
    }

    @JmsListener(destination = "product.create", containerFactory = "jmsFactory")
    public void receiveMessage(Product product) {
        productService.save(product);
    }
}
