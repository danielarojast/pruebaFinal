package com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces;

import com.riwi.pruebaFinaRiwi.api.dto.requests.ProductRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.ProductResponse;

public interface IProductService extends CrudService<ProductRequest, ProductResponse, String> {
    public ProductResponse findById(String id);
}
