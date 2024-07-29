package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.VouchersResponse;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IVoucherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/voucher")
@Tag(name="Endpoints Voucher")
public class VoucherController {

    private final IVoucherService voucherService;

    @Operation(summary = "Create Voucher",
    description = "Create Voucher")
    /*CREATE */
    @PostMapping
    public ResponseEntity<VouchersResponse> create(@Validated @RequestBody VoucherRequest request) {
        return ResponseEntity.ok(this.voucherService.create(request));
    }

    /*Get All */
    @Operation(summary = "List EveryVouchers", 
    description = " List EveryVouchers")
    @GetMapping
    public ResponseEntity<Page<VouchersResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.voucherService.findAll(page-1, size));
    }

    /*DELETE */
    @Operation(summary = "Delete Voucher",
    description = "  Enter the id to delete the voucher")
    @ApiResponse(responseCode = "400", 
    description = "id not found", 
    content = {@Content(mediaType= "application/json", schema= @Schema(implementation = ErrorResponse.class))})
    @DeleteMapping(path = "/{id}") 
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.voucherService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*UPDATE */
    @Operation(summary = "Update Voucher", 
    description = "Enter the id and updated information")
    @ApiResponse(responseCode = "400", 
    description = "id not found", 
    content = {@Content(mediaType= "application/json", schema= @Schema(implementation = ErrorResponse.class))})
    @PutMapping(path = "/{id}") 
    public ResponseEntity<VouchersResponse> update(@PathVariable String id, @Validated @RequestBody VoucherRequest request) {
        return ResponseEntity.ok(this.voucherService.update(id, request));
    }
}