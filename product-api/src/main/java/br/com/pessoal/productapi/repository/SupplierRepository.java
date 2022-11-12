package br.com.pessoal.productapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pessoal.productapi.dto.SupplierResponse;
import br.com.pessoal.productapi.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("""
            select new br.com.pessoal.productapi.dto.SupplierResponse(s.id, s.name) from Supplier s
                """)
    List<SupplierResponse> all();

    Supplier getById(@Param("id") Integer id);

}
