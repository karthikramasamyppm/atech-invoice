package br.com.atech.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import br.com.atech.entity.Invoice;
import br.com.atech.jms.InvoiceCreateProducer;
import br.com.atech.repository.InvoiceRepository;
import br.com.atech.repository.filter.InvoiceSearchFilter;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository repository;

    @Mock
    private InvoiceCreateProducer producer;

    private InvoiceService service;

    @Before
    public void setUp() {
        service = new InvoiceServiceImpl(repository, producer);
    }

    @Test
    public void testShouldReturnAValidInvoiceWhenfindOneByIdIsCalledWithAValidId() {
        final Invoice expectedInvoice = stubServiceToReturnValidInvoice();

        Invoice returnedInvoice = service.findOneById(1L);

        verify(repository, times(1)).findOne(1L);
        assertEquals("Should return a valid invoice", expectedInvoice, returnedInvoice);
    }

    @Test
    public void testShouldSaveInvoice() {
        final Invoice expectedInvoice = stubServiceToReturnStoredInvoice();
        final Invoice invoice = new Invoice();

        Invoice returnedInvoice = service.save(invoice);

        verify(repository, times(1)).save(invoice);
        assertEquals("Should create an invoice", expectedInvoice, returnedInvoice);
    }

    @Test
    public void testShouldProduceJmsMessageWhenSaveAsyncIsCalled() {
        final Invoice invoice = stubServiceToReturnStoredAsyncInvoice();

        service.saveAsync(invoice);

        verify(producer, times(1)).send(invoice);
    }

    @Test
    public void testShouldReturnAllInvoicesWhenFindAllByInvoiceSearchFilterIsCalled() {
        final Page<Invoice> expectedInvoices = stubServiceToReturnValidInvoices();

        final Pageable pageRequest = new PageRequest(0, 10, Sort.Direction.ASC, "id");
        final InvoiceSearchFilter filter = new InvoiceSearchFilter();

        Page<Invoice> returnedInvoices = service.findAllByInvoiceSearchFilter(filter, pageRequest);

        verify(repository, times(1)).findAll(pageRequest);
        assertEquals("Should return a list with all invoices", expectedInvoices, returnedInvoices);
        assertEquals(expectedInvoices.getTotalElements(), returnedInvoices.getTotalElements());
    }

    @Test
    public void testShouldReturnAllInvoicesWhenFindAllByInvoiceSearchFilterIsCalledWithParamCompanyId() {
        final Page<Invoice> expectedInvoices = stubServiceToReturnValidInvoicesWithParameterCompanyId();

        final Pageable pageRequest = new PageRequest(0, 10, Sort.Direction.ASC, "id");
        final InvoiceSearchFilter filter = new InvoiceSearchFilter(1L, null, null);

        Page<Invoice> returnedInvoices = service.findAllByInvoiceSearchFilter(filter, pageRequest);

        verify(repository, times(1)).findAllByCompanyId(filter.getCompanyId(), pageRequest);
        assertEquals("Should return a list with all invoices", expectedInvoices, returnedInvoices);
        assertEquals(expectedInvoices.getTotalElements(), returnedInvoices.getTotalElements());
    }

    @Test
    public void testShouldReturnAllInvoicesWhenFindAllByInvoiceSearchFilterIsCalledWithParamProductId() {
        final Page<Invoice> expectedInvoices = stubServiceToReturnValidInvoicesWithParameterProductId();

        final Pageable pageRequest = new PageRequest(0, 10, Sort.Direction.ASC, "id");
        final InvoiceSearchFilter filter = new InvoiceSearchFilter(null, 1L, null);

        Page<Invoice> returnedInvoices = service.findAllByInvoiceSearchFilter(filter, pageRequest);

        verify(repository, times(1)).findAllByItemProductId(filter.getProductId(), pageRequest);
        assertEquals("Should return a list with all invoices", expectedInvoices, returnedInvoices);
        assertEquals(expectedInvoices.getTotalElements(), returnedInvoices.getTotalElements());
    }

    @Test
    public void testShouldReturnAllInvoicesWhenFindAllByInvoiceSearchFilterIsCalledWithParamProductName() {
        final Page<Invoice> expectedInvoices = stubServiceToReturnValidInvoicesWithParameterProductName();

        final Pageable pageRequest = new PageRequest(0, 10, Sort.Direction.ASC, "id");
        final InvoiceSearchFilter filter = new InvoiceSearchFilter(null, null, "Foo");

        Page<Invoice> returnedInvoices = service.findAllByInvoiceSearchFilter(filter, pageRequest);

        verify(repository, times(1)).findAllByItemProductName(filter.getProductName(), pageRequest);
        assertEquals("Should return a list with all invoices", expectedInvoices, returnedInvoices);
        assertEquals(expectedInvoices.getTotalElements(), returnedInvoices.getTotalElements());
    }

    private Invoice stubServiceToReturnValidInvoice() {
        final Invoice invoice = new Invoice();

        when(repository.findOne(any(Long.class))).thenReturn(invoice);

        return invoice;
    }

    private Invoice stubServiceToReturnStoredInvoice() {
        final Invoice invoice = new Invoice();

        when(repository.save(any(Invoice.class))).thenReturn(invoice);

        return invoice;
    }

    private Invoice stubServiceToReturnStoredAsyncInvoice() {
        final Invoice invoice = new Invoice();

        doNothing().when(producer).send(any(Invoice.class));

        return invoice;
    }

    private Page<Invoice> stubServiceToReturnValidInvoices() {
        final Invoice firstInvoice = new Invoice();
        final Invoice secondInvoice = new Invoice();

        final List<Invoice> invoices = Arrays.asList(firstInvoice, secondInvoice);
        final Page<Invoice> expectedInvoices = new PageImpl<>(invoices);

        when(repository.findAll(any(Pageable.class))).thenReturn(expectedInvoices);

        return expectedInvoices;
    }

    private Page<Invoice> stubServiceToReturnValidInvoicesWithParameterCompanyId() {
        final List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice());
        final Page<Invoice> expectedInvoices = new PageImpl<>(invoices);

        when(repository.findAllByCompanyId(any(Long.class), any(Pageable.class))).thenReturn(expectedInvoices);

        return expectedInvoices;
    }

    private Page<Invoice> stubServiceToReturnValidInvoicesWithParameterProductId() {
        final List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice());
        final Page<Invoice> expectedInvoices = new PageImpl<>(invoices);

        when(repository.findAllByItemProductId(any(Long.class), any(Pageable.class))).thenReturn(expectedInvoices);

        return expectedInvoices;
    }

    private Page<Invoice> stubServiceToReturnValidInvoicesWithParameterProductName() {
        final List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice());
        final Page<Invoice> expectedInvoices = new PageImpl<>(invoices);

        when(repository.findAllByItemProductName(any(String.class), any(Pageable.class))).thenReturn(expectedInvoices);

        return expectedInvoices;
    }
}
