package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
@Tag(name="Endpoints Products")
public class ProductController {
    @Autowired
    private final IProductService productService;
    
}
