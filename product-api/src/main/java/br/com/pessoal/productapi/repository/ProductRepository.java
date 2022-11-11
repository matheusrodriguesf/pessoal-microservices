package br.com.pessoal.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pessoal.productapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
