package pe.edu.upc.NutriCare_API.payment.mapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.NutriCare_API.client.domain.model.entity.Client;
import pe.edu.upc.NutriCare_API.client.resource.ClientResource;
import pe.edu.upc.NutriCare_API.client.resource.CreateClientResource;
import pe.edu.upc.NutriCare_API.client.resource.UpdateClientResource;
import pe.edu.upc.NutriCare_API.shared.mapping.EnhancedModelMapper;
import pe.edu.upc.NutriCare_API.payment.domain.model.entity.Payment;
import pe.edu.upc.NutriCare_API.payment.resource.PaymentResource;
import pe.edu.upc.NutriCare_API.payment.resource.CreatePaymentResource;
import pe.edu.upc.NutriCare_API.payment.resource.UpdatePaymentResource;

import java.io.Serializable;
import java.util.List;

public class PaymentMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public PaymentResource toResource(Payment model) { return mapper.map(model, PaymentResource.class); }

    public Page<PaymentResource> modelListToPage(List<Payment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PaymentResource.class), pageable, modelList.size());
    }

    public Payment toModel(CreatePaymentResource resource) {
        return mapper.map(resource, Payment.class);
    }

    public Payment toModel(UpdatePaymentResource resource) { return mapper.map(resource, Payment.class); }
}
