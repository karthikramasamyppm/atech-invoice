package br.com.atech.entity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.atech.entity.ApiResponse;
import br.com.atech.entity.Invoice;
import br.com.atech.exception.ResourceNotFoundException;
import br.com.atech.repository.filter.InvoiceSearchFilter;
import br.com.atech.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Invoice> index( //
            @RequestParam(value = "companyId", required = false) Long companyId, //
            @RequestParam(value = "productId", required = false) Long productId, //
            @RequestParam(value = "productName", required = false) String productName, //
            Pageable pageable) {

        InvoiceSearchFilter filter = new InvoiceSearchFilter(companyId, productId, productName);

        return invoiceService.findAllByInvoiceSearchFilter(filter, pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice show(@PathVariable Long id) {
        Invoice invoice = invoiceService.findOneById(id);

        if (null == invoice) {
            throw new ResourceNotFoundException("Invoice not found");
        }

        return invoice;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse create(@RequestBody @Valid final Invoice invoice) {
        invoiceService.saveAsync(invoice);

        return new ApiResponse(HttpStatus.ACCEPTED);
    }
}
