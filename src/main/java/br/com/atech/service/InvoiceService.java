package br.com.atech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.atech.entity.Invoice;
import br.com.atech.repository.filter.InvoiceSearchFilter;

public interface InvoiceService {

    Page<Invoice> findAllByInvoiceSearchFilter(InvoiceSearchFilter filter, Pageable pageable);

    Invoice findOneById(Long id);

    Invoice save(Invoice invoice);

    void saveAsync(Invoice invoice);
}
