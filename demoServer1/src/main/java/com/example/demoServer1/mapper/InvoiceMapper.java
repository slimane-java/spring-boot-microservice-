package com.example.demoServer1.mapper;

import com.example.demoServer1.dto.InvoiceDtoGet;
import com.example.demoServer1.dto.InvoiceDtoPost;
import com.example.demoServer1.entity.Invoice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice invoicePostDtoToInvoice(InvoiceDtoPost invoiceDtoPost);
    InvoiceDtoGet invoiceToInvoiceGetDto(Invoice invoice);
    InvoiceDtoGet invoicePostDtoToInvoiceGetDto(InvoiceDtoPost invoiceDtoPost);

    List<InvoiceDtoGet> all(List<Invoice> invoices);

}
