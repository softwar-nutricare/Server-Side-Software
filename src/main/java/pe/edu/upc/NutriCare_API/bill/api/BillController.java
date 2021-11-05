package pe.edu.upc.NutriCare_API.bill.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NutriCare_API.client.domain.service.ClientService;
import pe.edu.upc.NutriCare_API.client.mapping.ClientMapper;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;
import pe.edu.upc.NutriCare_API.bill.domain.service.BillService;
import pe.edu.upc.NutriCare_API.bill.mapping.BillMapper;
import pe.edu.upc.NutriCare_API.bill.resource.BillResource;
import pe.edu.upc.NutriCare_API.bill.resource.CreateBillResource;
import pe.edu.upc.NutriCare_API.bill.resource.UpdateBillResource;

@RestController
@RequestMapping("api/v1/bills")
public class BillController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private BillService billService;

    @Autowired
    private BillMapper mapper;

    @GetMapping
    public Page<BillResource> getAllBills(Pageable pageable) {
        return mapper.modelListToPage(billService.getAll(), pageable);
    }

    @GetMapping("{billId}")
    public BillResource getBillById(@PathVariable("billId") Long billId) {
        return mapper.toResource(billService.getById(billId));
    }

    @PostMapping
    public BillResource createBill(@RequestBody CreateBillResource request) {
        return mapper.toResource(billService.create(mapper.toModel(request)));
    }

    @PutMapping("{billId}")
    public BillResource updateBill(@PathVariable Long billId, @RequestBody UpdateBillResource request) {
        return mapper.toResource(billService.update(billId, mapper.toModel(request)));
    }

    @DeleteMapping("{billId}")
    public ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        return billService.delete(billId);
    }
}
