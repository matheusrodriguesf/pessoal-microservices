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

import br.com.pessoal.productapi.dto.ProductForm;
import br.com.pessoal.productapi.dto.ProductResponse;
import br.com.pessoal.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductForm productForm) {
        return ResponseEntity.ok(productService.create(productForm));
    }

    @GetMapping
    public List<ProductResponse> all() {
        return productService.all();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Integer id, @RequestBody ProductForm productForm) {
        return productService.update(id, productForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
