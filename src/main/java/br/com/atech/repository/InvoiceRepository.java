package br.com.atech.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.atech.entity.Invoice;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {

    Page<Invoice> findAllByCompanyId(Long companyId, Pageable pageable);

    @Query("select i from Invoice i where i.id in "
            + "(select i.id from Invoice i join i.items ii join ii.product p where p.id = :productId)")
    Page<Invoice> findAllByItemProductId(@Param("productId") Long productId, Pageable pageable);

    @Query("select i from Invoice i where i.id in "
            + "(select i.id from Invoice i join i.items ii join ii.product p where p.name = :productName)")
    Page<Invoice> findAllByItemProductName(@Param("productName") String productName, Pageable pageable);
}
