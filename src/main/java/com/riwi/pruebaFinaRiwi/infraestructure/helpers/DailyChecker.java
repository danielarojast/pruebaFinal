package com.riwi.pruebaFinaRiwi.infraestructure.helpers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.riwi.pruebaFinaRiwi.domain.entities.Voucher;
import com.riwi.pruebaFinaRiwi.infraestructure.services.VoucherService;


@Component
@Configuration
@EnableScheduling
public class DailyChecker {
    @Autowired
    private VoucherService voucherService;

    @Scheduled(cron = "0 6 * * * *")
    public void verificaPorHora() {
        System.out.println(LocalDateTime.now());
        List<Voucher> vouchers = voucherService.findAllList();
        for (Voucher voucher : vouchers) {
            if (voucher.getExpirationDate() != null && voucher.getExpirationDate().isBefore(LocalDateTime.now())) {
                this.voucherService.delete(voucher.getId());
            }
        }
    }
}
