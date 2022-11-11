package br.com.pessoal.productapi.service;

import org.springframework.stereotype.Service;

import br.com.pessoal.productapi.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;
}
