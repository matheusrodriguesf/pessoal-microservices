package br.com.pessoal.productapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pessoal.productapi.dto.ProductResponse;
import br.com.pessoal.productapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new br.com.pessoal.productapi.dto.ProductResponse(p.id, p.name, p.description, p.price, p.quantity, c.name, s.name) FROM Product p JOIN p.category c JOIN p.supplier s")
    List<ProductResponse> all();

    @Query("SELECT new br.com.pessoal.productapi.dto.ProductResponse(p.id, p.name, p.description, p.price, p.quantity, c.name, s.name) FROM Product p JOIN p.category c JOIN p.supplier s WHERE p.id = :id")
    ProductResponse getProductById(@Param("id") Integer id);

}
