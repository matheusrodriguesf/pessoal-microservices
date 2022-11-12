package br.com.pessoal.productapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pessoal.productapi.dto.CategoryForm;
import br.com.pessoal.productapi.dto.CategoryResponse;
import br.com.pessoal.productapi.entity.Category;
import br.com.pessoal.productapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponse create(CategoryForm categoryForm) {
        var category = Category.builder()
                .name(categoryForm.getName())
                .description(categoryForm.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
        category = categoryRepository.save(category);
        return new CategoryResponse(category.getId(), category.getName(), category.getDescription(),
                category.getCreatedAt());
    }

    public List<CategoryResponse> all() {
        return categoryRepository.all();
    }

    public CategoryResponse findById(Integer id) {
        return categoryRepository.byID(id);
    }

    public CategoryResponse update(Integer id, CategoryForm categoryForm) {
        var category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryForm.getName());
        category.setDescription(categoryForm.getDescription());
        category.setUpdatedAt(LocalDateTime.now());
        category = categoryRepository.save(category);
        return new CategoryResponse(category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt());
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
