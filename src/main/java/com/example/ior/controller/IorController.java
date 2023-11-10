package com.example.ior.controller;

import com.example.ior.DTO.EmailRequest;
import com.example.ior.DTO.IncidentDTO;
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
    public ResponseEntity<?> createIor(@RequestBody @Validated IncidentDTO incidentDTO) {
        iorService.create(incidentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление ИОР")
    @PutMapping("/updateIor/{idIncident}")
    public ResponseEntity<?> updateIor(@PathVariable String idIncident, @RequestBody @Validated IncidentDTO incidentDTO) {
        iorService.updateIor(idIncident, incidentDTO);
        return new ResponseEntity<>(HttpStatus.OK);

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

//    @PostMapping("/batchCreate")
//    public ResponseEntity<String> batchCreateIor(@RequestParam MultipartFile file) {
//        iorService.batchCreate(file);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
