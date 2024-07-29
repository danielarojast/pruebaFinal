package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IUserEntityService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name="Endpoints Users")
public class UserEntityController {
    @Autowired
    private final IUserEntityService userService;
}
