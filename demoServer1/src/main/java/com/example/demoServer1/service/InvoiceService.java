package com.example.demoServer1.service;

import com.example.demoServer1.dto.InvoiceDtoGet;
import com.example.demoServer1.dto.MaterialGetDto;
import com.example.demoServer1.entity.Invoice;
import com.example.demoServer1.entityTarget.ClientGetDto;

import java.util.List;
import java.util.Optional;
public interface InvoiceService {
    Optional<Invoice>getInvoiceByClientOrder(Long idClient, Long idOrder);
    Invoice add(Invoice invoice);
    void delete(Long id);
    Invoice update(Long id, Invoice invoice);
    Optional<Invoice> findById(Long id);
    List<MaterialGetDto> getAllMaterial();
    List<ClientGetDto> getAllClientRestTemplate();
    List<Invoice> getAll();
}
