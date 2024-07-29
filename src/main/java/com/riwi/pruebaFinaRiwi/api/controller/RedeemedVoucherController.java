package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IRedeemedVoucherService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/redeemed")
@Tag(name="Endpoints RedeemedVouchers")
public class RedeemedVoucherController {
    private final IRedeemedVoucherService redeemedVoucherService;
}
