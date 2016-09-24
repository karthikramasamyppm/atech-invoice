package br.com.atech.jms;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.atech.entity.Invoice;

@Service
@Transactional
public class InvoiceCreateProducer {

    private ConfigurableApplicationContext appContext;

    @Autowired
    public InvoiceCreateProducer(ConfigurableApplicationContext appContext) {
        this.appContext = appContext;
    }

    public void send(Invoice invoice) {
        JmsTemplate jmsTemplate = appContext.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("invoice.create", invoice);
    }
}
