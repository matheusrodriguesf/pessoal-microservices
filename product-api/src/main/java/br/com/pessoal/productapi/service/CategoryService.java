package br.com.pessoal.productapi.service;

import org.springframework.stereotype.Service;

import br.com.pessoal.productapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
}
