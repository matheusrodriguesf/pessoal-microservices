package br.com.pessoal.productapi.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CategoryResponse(Integer id, String name, String description, String createdAt, String updatedAt) {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CategoryResponse(Integer id, String name, String description, LocalDateTime createdAt) {
        this(id, name, description, createdAt.format(formatter), null);
    }

    public CategoryResponse(Integer id, String name, String description, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this(id, name, description, createdAt.format(formatter), updatedAt.format(formatter));
    }
}
