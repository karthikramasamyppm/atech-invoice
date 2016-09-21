package br.com.atech.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.atech.entity.Invoice;
import br.com.atech.repository.InvoiceRepository;
import br.com.atech.repository.filter.InvoiceSearchFilter;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Page<Invoice> findAllByInvoiceSearchFilter(InvoiceSearchFilter filter, Pageable pageable) {

        if (null != filter.getCompanyId()) {
            return invoiceRepository.findAllByCompanyId(filter.getCompanyId(), pageable);
        }

        if (null != filter.getProductId()) {
            return invoiceRepository.findAllByItemProductId(filter.getProductId(), pageable);
        }

        if (null != filter.getProductName()) {
            return invoiceRepository.findAllByItemProductName(filter.getProductName(), pageable);
        }

        return invoiceRepository.findAll(pageable);
    }
}
