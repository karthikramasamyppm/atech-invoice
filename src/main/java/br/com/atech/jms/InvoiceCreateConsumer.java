package br.com.atech.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.atech.entity.Invoice;
import br.com.atech.service.InvoiceService;

@Component
public class InvoiceCreateConsumer {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceCreateConsumer(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @JmsListener(destination = "invoice.create", containerFactory = "jmsFactory")
    public void receiveMessage(Invoice invoice) {
        invoiceService.save(invoice);
    }
}
