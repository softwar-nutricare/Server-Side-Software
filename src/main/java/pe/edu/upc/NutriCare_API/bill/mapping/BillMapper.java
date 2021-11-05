package pe.edu.upc.NutriCare_API.bill.mapping;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;
import pe.edu.upc.NutriCare_API.bill.domain.model.entity.Bill;
import pe.edu.upc.NutriCare_API.bill.resource.BillResource;
import pe.edu.upc.NutriCare_API.bill.resource.CreateBillResource;
import pe.edu.upc.NutriCare_API.bill.resource.UpdateBillResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class BillMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public BillResource toResource(Bill model) { return mapper.map(model, BillResource.class); }

    public Page<BillResource> modelListToPage(List<Bill> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, BillResource.class), pageable, modelList.size());
    }

    public Bill toModel(CreateBillResource resource) {
        return mapper.map(resource, Bill.class);
    }

    public Bill toModel(UpdateBillResource resource) { return mapper.map(resource, Bill.class); }
}
