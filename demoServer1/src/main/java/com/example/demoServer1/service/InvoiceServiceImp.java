package com.example.demoServer1.service;

//import com.example.demoServer1.dao.InvoiceRepository;
import com.example.demoServer1.dao.InvoiceRepository;
import com.example.demoServer1.dto.InvoiceDtoGet;
import com.example.demoServer1.entity.Invoice;
import com.example.demoServer1.entityTarget.ClientGetDto;
import com.example.demoServer1.enums.ExceptionMessage;
import com.example.demoServer1.exception.InvoiceAlreadyExists;
import com.example.demoServer1.exception.InvoiceNotFound;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImp implements InvoiceService{

    private final InvoiceRepository invoiceRepository;
    private final UserFeignClientService clientService;
    private final RestTemplate restTemplate;
    @Override
    public Optional<Invoice> getInvoiceByClientOrder(Long idClient, Long idOrder) {
        return invoiceRepository.findByClientWithOrder(idClient, idOrder);
    }

    @Override
    public Invoice add(Invoice invoiceData) {

        Optional<Invoice> invoice = invoiceRepository.findByClientWithOrder(invoiceData.getIdClient(), invoiceData.getIdOrder());

        return getInvoice(invoiceData, invoice);
    }

    private Invoice getInvoice(Invoice invoiceData, Optional<Invoice> invoice) {
        if(invoice.isPresent()) {
            throw new InvoiceAlreadyExists(ExceptionMessage.IS_EXISTS.toString());
        }else {

            return invoiceRepository.save(invoiceData);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Invoice> invice = invoiceRepository.findById(id);
        /*if(invice.isPresent()) {
            invoiceRepository.deleteById(id);

        } else {
            throw new InvoiceNotFound(ExceptionMessage.Not_FOUND.toString());
        }*/

        invice.ifPresentOrElse(invoice -> {
        },() -> {
            throw new InvoiceNotFound(ExceptionMessage.Not_FOUND.toString());
        });
    }

    @Override
    public Invoice update(Long id, Invoice invoiceData) {

        Optional<Invoice> invoiceSearch = invoiceRepository.findByClientWithOrder(invoiceData.getIdClient(), invoiceData.getIdOrder());

        if(invoiceSearch.isPresent()){
            throw new InvoiceAlreadyExists(ExceptionMessage.IS_EXISTS.toString());
        }
        Optional<Invoice> invice = invoiceRepository.findById(id);

        Invoice inviceupdate = invice.orElseThrow(() -> new InvoiceNotFound(ExceptionMessage.Not_FOUND.toString()));
        inviceupdate.setIdOrder(invoiceData.getIdOrder());
        inviceupdate.setIdClient(invoiceData.getIdClient());
        inviceupdate.setPriceTotal(invoiceData.getPriceTotal());

        return invoiceRepository.save(inviceupdate);
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<ClientGetDto> getAllClient() {
        return clientService.getAllClientTest();
    }

    public List<ClientGetDto> getAllClientRestTemplate() {
        System.out.println("ok ok ok");
        ResponseEntity<ClientGetDto[]> list = restTemplate.getForEntity("http://material-server/api-demo-service-support/materials/all", ClientGetDto[].class);
        return Arrays.asList(Objects.requireNonNull(list.getBody()));
    }

    @Override
    public List<Invoice> getAll() {
     return invoiceRepository.findAll();
    }

    public List<ClientGetDto> getInvoiceFallback(Exception e) {
        log.info("---RESPONSE FROM FALLBACK METHOD---");
        List<ClientGetDto> list = new ArrayList<>();
        return list;
    }


}
