package pe.edu.upc.NutriCare_API.payment.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.bill.domain.service.BillService;
import pe.edu.upc.NutriCare_API.bill.mapping.BillMapper;
import pe.edu.upc.NutriCare_API.bill.resource.BillResource;
import pe.edu.upc.NutriCare_API.bill.resource.CreateBillResource;
import pe.edu.upc.NutriCare_API.bill.resource.UpdateBillResource;
import pe.edu.upc.NutriCare_API.client.domain.service.ClientService;
import pe.edu.upc.NutriCare_API.client.mapping.ClientMapper;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;

import pe.edu.upc.NutriCare_API.payment.domain.service.PaymentService;
import pe.edu.upc.NutriCare_API.payment.mapping.PaymentMapper;
import pe.edu.upc.NutriCare_API.payment.resource.PaymentResource;
import pe.edu.upc.NutriCare_API.payment.resource.CreatePaymentResource;
import pe.edu.upc.NutriCare_API.payment.resource.UpdatePaymentResource;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMapper mapper;


    @GetMapping
    public Page<PaymentResource> getAllPayments(Pageable pageable) {
        return mapper.modelListToPage(paymentService.getAll(), pageable);
    }

    @GetMapping("{paymentId}")
    public PaymentResource getPaymentById(@PathVariable("paymentId") Long paymentId) {
        return mapper.toResource(paymentService.getById(paymentId));
    }

    @PostMapping
    public PaymentResource createPayment(@RequestBody CreatePaymentResource request) {
        return mapper.toResource(paymentService.create(mapper.toModel(request)));
    }

    @PutMapping("{paymentId}")
    public PaymentResource updatePayment(@PathVariable Long paymentId, @RequestBody UpdatePaymentResource request) {
        return mapper.toResource(paymentService.update(paymentId, mapper.toModel(request)));
    }

    @DeleteMapping("{paymentId}")
    public ResponseEntity<?> deletePayment(@PathVariable Long paymentId) {
        return paymentService.delete(paymentId);
    }













}
