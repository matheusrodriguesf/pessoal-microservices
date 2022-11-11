package br.com.pessoal.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pessoal.productapi.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
