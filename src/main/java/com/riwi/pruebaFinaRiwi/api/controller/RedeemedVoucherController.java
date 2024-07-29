package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.api.dto.requests.ProductRequest;
import com.riwi.pruebaFinaRiwi.api.dto.requests.VoucherRedeemedRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.ProductResponse;
import com.riwi.pruebaFinaRiwi.api.dto.response.VoucherRedeemedResponse;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IRedeemedVoucherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/redeemed")
@Tag(name="Endpoints RedeemedVouchers")
public class RedeemedVoucherController {
    private final IRedeemedVoucherService redeemedVoucherService;

    @Operation(summary = "this endpoint allows users to redeem coupons", description = "Just have send all the params required for the voucher.")
    @PostMapping
    public ResponseEntity<VoucherRedeemedResponse> insert(
            @Validated @RequestBody VoucherRedeemedRequest VoucherRedeemedRequest) {
        return ResponseEntity.ok(this.redeemedVoucherService.create(VoucherRedeemedRequest));
    }

    @Operation(summary = "This EndPoint gets all registered voucher, it also has a paging function that only displays depending on the page and listing size.", description = "you must send the page and corresponding size to list the voucher ")
    @GetMapping
    public ResponseEntity<Page <VoucherRedeemedResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "2") int size
    ) {

        return ResponseEntity.ok(this.redeemedVoucherService.findAll(page - 1, size));
    }
}
