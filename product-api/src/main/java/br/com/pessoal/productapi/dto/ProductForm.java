package br.com.pessoal.productapi.dto;

public record ProductForm(String name, String description, Double price, Integer quantity, Integer categoryId,
        Integer supplierId) {
}
