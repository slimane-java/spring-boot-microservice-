package com.example.demoServer1.api;

import com.example.demoServer1.dto.InvoiceDtoGet;
import com.example.demoServer1.dto.InvoiceDtoPost;
import com.example.demoServer1.dto.MaterialGetDto;
import com.example.demoServer1.entity.Invoice;
import com.example.demoServer1.entityTarget.ClientGetDto;
import com.example.demoServer1.enums.ExceptionMessage;
import com.example.demoServer1.exception.InvoiceAlreadyExists;
import com.example.demoServer1.exception.InvoiceNotFound;
import com.example.demoServer1.mapper.InvoiceMapper;
import com.example.demoServer1.service.InvoiceService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
@Slf4j
public class ApiController {

    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    private final WebClient.Builder webClient;
    private final RestTemplate restTemplate;


    @GetMapping("/getAllMaterial")
    public ResponseEntity<List<Object>> getAllMaterial(){
//        MaterialGetDto[] materialGetDtos = webClient.build()
//                .get()
//                .uri("http://localhost:8060/api-demo-service-support/materials/all")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(MaterialGetDto[].class)
//                .block()
//                ;

//        ResponseEntity<MaterialGetDto[]> list = restTemplate.getForEntity("http://material-server/api-demo-service-support/materials/all", MaterialGetDto[].class);
        Object[] list = restTemplate.getForObject("http://localhost:8060/api-demo-service-support/materials/all", Object[].class);

        List<Object> result = Arrays.asList(list);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/all")
    public ResponseEntity<List<InvoiceDtoGet>> getAllInvoicesApi(){
        return ResponseEntity.ok(invoiceMapper.all(invoiceService.getAll()));
    }

    @GetMapping("/all-test")
    @RateLimiter(name = "allTest", fallbackMethod = "getMessageFallBack")
    public ResponseEntity<String> allTest(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/allMaterial")
//    @Retry(name = "getAllClient", fallbackMethod = "getInvoiceFallback")
    public ResponseEntity<List<MaterialGetDto>> getAllClientApi(){

        return ResponseEntity.ok(invoiceService.getAllMaterial());
    }

    @GetMapping("/getAllClientRestTemplate")
    @Retry(name = "getAllClient", fallbackMethod = "getInvoiceFallback")
    public ResponseEntity<List<ClientGetDto>> getAllClientApiRestTemplate(){
        return ResponseEntity.ok(invoiceService.getAllClientRestTemplate());
    }

    public ResponseEntity<List<ClientGetDto>> getInvoiceFallback(Exception e) {
        log.info("---RESPONSE FROM FALLBACK METHOD---");
        List<ClientGetDto> list = new ArrayList<>();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<String> getMessageFallBack(RequestNotPermitted exception) {

        log.info("Rate limit has applied, So no further calls are getting accepted");

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body("Too many requests : No further request will be accepted. Please try after sometime");
    }

    @GetMapping("/createe")
    public String create() throws InvoiceAlreadyExists {
        return "Api create";
    }

    @PostMapping("/create")
    public InvoiceDtoGet create(@RequestBody InvoiceDtoPost invoiceDtoPost) throws InvoiceAlreadyExists {
        Invoice invoice = invoiceMapper.invoicePostDtoToInvoice(invoiceDtoPost);
        return invoiceMapper.invoiceToInvoiceGetDto(invoiceService.add(invoice));
    }

    @GetMapping("/getByClientWithOrder/{idClient}/{idOrder}")
    public InvoiceDtoGet getInvoiceByClientOrder(@PathVariable(value = "idClient") Long idClient, @PathVariable(value = "idOrder") Long idOrder) throws InvoiceNotFound {
        Optional<Invoice> invoice = invoiceService.getInvoiceByClientOrder(idClient, idOrder);
        Invoice i = invoice.orElseThrow(()->new InvoiceNotFound(ExceptionMessage.Not_FOUND.toString()));

        return invoiceMapper.invoiceToInvoiceGetDto(i);
    }

    @GetMapping("/getById/{id}")
    public InvoiceDtoGet getInvoiceByClientOrder(@PathVariable(value = "id") Long id) throws InvoiceNotFound {
        Optional<Invoice> invoice = invoiceService.findById(id);
        Invoice i = invoice.orElseThrow(()->new InvoiceNotFound(ExceptionMessage.Not_FOUND.toString()));

        return invoiceMapper.invoiceToInvoiceGetDto(i);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) throws InvoiceNotFound {
        invoiceService.delete(id);
    }

    @PutMapping("/update/{id}")
    public InvoiceDtoGet update(@PathVariable(value = "id") Long id, @RequestBody InvoiceDtoPost invoiceDtoPost) throws InvoiceNotFound {
        Invoice invoice = invoiceMapper.invoicePostDtoToInvoice(invoiceDtoPost);
        return invoiceMapper.invoiceToInvoiceGetDto(invoiceService.update(id, invoice));
    }

}
