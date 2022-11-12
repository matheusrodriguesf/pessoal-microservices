package br.com.pessoal.productapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pessoal.productapi.dto.ProductForm;
import br.com.pessoal.productapi.dto.ProductResponse;
import br.com.pessoal.productapi.entity.Category;
import br.com.pessoal.productapi.entity.Product;
import br.com.pessoal.productapi.entity.Supplier;
import br.com.pessoal.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse create(ProductForm productForm) {
        var product = Product.builder()
                .name(productForm.name())
                .description(productForm.description())
                .price(productForm.price())
                .quantity(productForm.quantity())
                .category(Category.builder().id(productForm.categoryId()).build())
                .supplier(Supplier.builder().id(productForm.supplierId()).build())
                .build();
        product = productRepository.save(product);
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getName(),
                product.getSupplier().getName());

    }

    public List<ProductResponse> all() {
        return productRepository.all();
    }

    public ProductResponse findById(Integer id) {
        return productRepository.getProductById(id);
    }

    public ProductResponse update(Integer id, ProductForm productForm) {
        var product = Product.builder()
                .id(id)
                .name(productForm.name())
                .description(productForm.description())
                .price(productForm.price())
                .quantity(productForm.quantity())
                .category(Category.builder().id(productForm.categoryId()).build())
                .supplier(Supplier.builder().id(productForm.supplierId()).build())
                .build();
        product = productRepository.save(product);
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getName(),
                product.getSupplier().getName());
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
