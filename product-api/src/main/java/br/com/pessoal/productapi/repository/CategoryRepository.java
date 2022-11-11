package br.com.pessoal.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pessoal.productapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

