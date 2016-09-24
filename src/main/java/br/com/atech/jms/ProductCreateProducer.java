package br.com.atech.jms;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.atech.entity.Product;

@Service
@Transactional
public class ProductCreateProducer {

    private ConfigurableApplicationContext appContext;

    @Autowired
    public ProductCreateProducer(ConfigurableApplicationContext appContext) {
        this.appContext = appContext;
    }

    public void send(Product product) {
        JmsTemplate jmsTemplate = appContext.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("product.create", product);
    }
}
