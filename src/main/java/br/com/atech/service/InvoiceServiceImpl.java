package br.com.atech.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.atech.entity.Invoice;
import br.com.atech.jms.InvoiceCreateProducer;
import br.com.atech.repository.InvoiceRepository;
import br.com.atech.repository.filter.InvoiceSearchFilter;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;

    private final InvoiceCreateProducer producer;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository repository, InvoiceCreateProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Override
    public Page<Invoice> findAllByInvoiceSearchFilter(InvoiceSearchFilter filter, Pageable pageable) {

        if (null != filter.getCompanyId()) {
            return repository.findAllByCompanyId(filter.getCompanyId(), pageable);
        }

        if (null != filter.getProductId()) {
            return repository.findAllByItemProductId(filter.getProductId(), pageable);
        }

        if (null != filter.getProductName()) {
            return repository.findAllByItemProductName(filter.getProductName(), pageable);
        }

        return repository.findAll(pageable);
    }

    @Override
    public Invoice findOneById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public void saveAsync(Invoice invoice) {
        producer.send(invoice);
    }
}
