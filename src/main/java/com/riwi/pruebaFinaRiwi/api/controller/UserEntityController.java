package com.riwi.pruebaFinaRiwi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.pruebaFinaRiwi.api.dto.requests.UserEntityRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.UserEntityResponse;
import com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces.IUserEntityService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/user")
@Tag(name="Endpoints Users")
public class UserEntityController {
    @Autowired
    private final IUserEntityService userService;

    @PostMapping()
    public ResponseEntity<UserEntityResponse> create(UserEntityRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<UserEntityResponse>> getAll() {
        return ResponseEntity.ok(userService.findAll(0, 10));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntityResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntityResponse> update(@PathVariable String id, UserEntityRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
