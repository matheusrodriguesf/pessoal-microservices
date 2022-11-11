package br.com.pessoal.productapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pessoal.productapi.dto.SupplierFormDTO;
import br.com.pessoal.productapi.dto.SupplierResponseDto;
import br.com.pessoal.productapi.service.SupplierService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDto> create(@RequestBody SupplierFormDTO supplierForm) {
        var supplier = supplierService.create(supplierForm);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping
    public List<SupplierResponseDto> all() {
        return supplierService.all();
    }

    @GetMapping("/{id}")
    public SupplierResponseDto findById(@PathVariable Integer id) {
        return supplierService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> update(@PathVariable Integer id, @RequestBody SupplierFormDTO supplierForm) {
        var supplier = supplierService.update(id, supplierForm);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
