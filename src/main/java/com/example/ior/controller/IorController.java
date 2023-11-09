package com.example.ior.controller;

import com.example.ior.DTO.EmailRequest;
import com.example.ior.Entity.IncidentEntity;
import com.example.ior.service.IorServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ior")
public class IorController {
    private final IorServiceImp iorService;

    public IorController(IorServiceImp iorService) {
        this.iorService = iorService;
    }

    @Operation(summary = "Регистрация одного ИОР")
    @PostMapping("/create")
    public ResponseEntity<?> createIor(@RequestBody @Validated IncidentEntity incidentEntity) {
        iorService.create(incidentEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest, IncidentEntity incidentEntity) {
        iorService.sendEmail(emailRequest, incidentEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getIor")
    public ResponseEntity<Page<IncidentEntity>> getIor(
            @RequestParam(name = "filterField", required = false) String filterField,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Specification<IncidentEntity> spec = null;
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(iorService.getAllIor(spec, pageable), HttpStatus.OK);

    }
}
