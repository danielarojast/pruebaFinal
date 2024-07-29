package com.riwi.pruebaFinaRiwi.infraestructure.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.pruebaFinaRiwi.api.dto.requests.ProductRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.ProductResponse;
import com.riwi.pruebaFinaRiwi.domain.Repositories.ProductRepository;
import com.riwi.pruebaFinaRiwi.domain.entities.Product;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IProductService;
import com.riwi.pruebaFinaRiwi.infraestructure.helpers.mappers.ProductMapper;
import com.riwi.pruebaFinaRiwi.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = this.productMapper.requestToEntity(request);
        return this.productMapper.entityToResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse update(String id, ProductRequest request) {
        Product product = this.find(id);
        product = this.productMapper.requestToEntity(request);
        return this.productMapper.entityToResponse(productRepository.save(product));
    }

    @Override
    public void delete(String id) {
        Product product = this.find(id);
        productRepository.delete(product);
    }

    @Override
    public Page<ProductResponse> findAll(int page, int size) {
        if (page < 0)
            page = 0;
        
        PageRequest pageRequest = PageRequest.of(page, size);
        return this.productRepository.findAll(pageRequest).map(this.productMapper::entityToResponse);
    }

    @Override
    public ProductResponse findById(String id) {
        return this.productMapper.entityToResponse(this.find(id));
    }
    
    private Product find(String id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay registros con el ID suministrado"));
    }

}
