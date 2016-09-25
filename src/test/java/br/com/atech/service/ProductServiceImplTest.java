package br.com.atech.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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

import br.com.atech.entity.Product;
import br.com.atech.jms.ProductCreateProducer;
import br.com.atech.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductCreateProducer productCreateProducer;

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl(productRepository, productCreateProducer);
    }

    @Test
    public void testShouldReturnAValidProductWhenfindOneByIdIsCalledWithAValidId() {
        final Product expectedProduct = stubServiceToReturnValidProduct();

        Product returnedProduct = productService.findOneById(1L);

        verify(productRepository, times(1)).findOne(1L);
        assertEquals("Should return a valid product", expectedProduct, returnedProduct);
    }

    @Test
    public void testShouldReturnAllProducts() {
        final Page<Product> expectedProducts = stubServiceToReturnValidProducts();

        final Pageable pageRequest = new PageRequest(0, 10, Sort.Direction.ASC, "id");

        Page<Product> returnedProducts = productService.findAll(pageRequest);

        verify(productRepository, times(1)).findAll(pageRequest);
        assertEquals("Should return a list of product", expectedProducts, returnedProducts);
        assertEquals(expectedProducts.getTotalElements(), returnedProducts.getTotalElements());
    }

    @Test
    public void testShouldSaveProduct() {
        final Product expectedProduct = stubServiceToReturnStoredProduct();
        final Product product = new Product();

        Product returnedProduct = productService.save(product);

        verify(productRepository, times(1)).save(product);
        assertEquals("Should create a product", expectedProduct, returnedProduct);
    }

    @Test
    public void testShouldProduceJmsMessageWhenSaveAsyncIsCalled() {
        final Product product = stubServiceToReturnStoredAsyncProduct();

        productService.saveAsync(product);

        verify(productCreateProducer, times(1)).send(product);
    }

    private Product stubServiceToReturnValidProduct() {
        final Product product = new Product();

        when(productRepository.findOne(any(Long.class))).thenReturn(product);

        return product;
    }

    private Page<Product> stubServiceToReturnValidProducts() {
        final Product firstProduct = new Product(1L, "Foo", new BigDecimal(1000));
        final Product secondProduct = new Product(2L, "Bar", new BigDecimal(2000));

        final List<Product> products = Arrays.asList(firstProduct, secondProduct);
        final Page<Product> expectedProducts = new PageImpl<>(products);

        when(productRepository.findAll(any(Pageable.class))).thenReturn(expectedProducts);

        return expectedProducts;
    }

    private Product stubServiceToReturnStoredProduct() {
        final Product product = new Product();

        when(productRepository.save(any(Product.class))).thenReturn(product);

        return product;
    }

    private Product stubServiceToReturnStoredAsyncProduct() {
        final Product product = new Product();

        doNothing().when(productCreateProducer).send(any(Product.class));

        return product;
    }
}
