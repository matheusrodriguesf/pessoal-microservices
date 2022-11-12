package br.com.pessoal.productapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pessoal.productapi.dto.CategoryResponse;
import br.com.pessoal.productapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT new br.com.pessoal.productapi.dto.CategoryResponse(c.id, c.name, c.description, c.createdAt) FROM Category c")
    List<CategoryResponse> all();

    @Query("SELECT new br.com.pessoal.productapi.dto.CategoryResponse(c.id, c.name, c.description, c.createdAt) FROM Category c WHERE c.id = :id")
    CategoryResponse byID(@Param("id") Integer id);
}
