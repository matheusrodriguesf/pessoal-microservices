package br.com.pessoal.productapi.dto;

public record ProductResponse(Integer id,
                String name,
                String description,
                Double price,
                Integer quantity,
                String categoryName,
                String supplierName) {
}