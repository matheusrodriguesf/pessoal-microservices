package br.com.pessoal.productapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
}
