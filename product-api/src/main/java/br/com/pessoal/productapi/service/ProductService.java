package br.com.pessoal.productapi.service;

import org.springframework.stereotype.Service;

import br.com.pessoal.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
}
