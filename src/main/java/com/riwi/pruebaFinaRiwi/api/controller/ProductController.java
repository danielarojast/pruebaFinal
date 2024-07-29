package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.api.dto.requests.ProductRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.ProductResponse;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
@Tag(name="Endpoints Products")
public class ProductController {
    @Autowired
    private final IProductService productService;

    @Operation(summary = "This EndPoint gets all registered products, it also has a paging function that only displays depending on the page and listing size.", description = "you must send the page and corresponding size to list the products")
    @GetMapping
    public ResponseEntity<Page <ProductResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "2") int size
    ) {

        return ResponseEntity.ok(this.productService.findAll(page - 1, size));
    }
    

    @ApiResponse(responseCode = "400", description = "When the ID is wrong.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "This EndPoint gets an product depending his ID.", description = "Just have send an ID, and if that ID is same as product's ID, It is obtained and It will be displayed.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @Operation(summary = "This EndPoint insert an product depending his requirements and params.", description = "Just have send all the params required for the product.")
    @PostMapping
    public ResponseEntity<ProductResponse> insert(
            @Validated @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(this.productService.create(productRequest));
    }
    

    @Operation(summary = "This EndPoint delete an product depending his ID", description = "Just have send an ID, and if that ID is same as product's ID, It will be eliminated.")
    @ApiResponse(responseCode = "400", description = "When the ID is wrong.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ){
    this.productService.delete(id);

    return ResponseEntity.noContent().build();
    
    }

    
    @ApiResponse(responseCode = "400", description = "When the ID is wrong.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
})
    @Operation(summary = "This EndPoint update an user depending his ID", description = "Just have send an ID, and if that ID is same as user's ID, It will be update, but you have to send the news params.")
    @PutMapping(path="/{id}")
    public ResponseEntity<ProductResponse> update(@Validated @PathVariable String id, @RequestBody ProductRequest entity) {
        return ResponseEntity.ok(this.productService.update(id, entity));
    }

}
