package com.example.demoServer1.dao;

import com.example.demoServer1.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("select i from Invoice i where i.idClient = :idClient and i.idOrder = :idOrder")
    Optional<Invoice> findByClientWithOrder(@Param("idClient") Long idClient,@Param("idOrder") Long idOrder);
}
