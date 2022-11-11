package br.com.pessoal.productapi.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.pessoal.productapi.dto.SupplierFormDTO;
import br.com.pessoal.productapi.dto.SupplierResponseDto;
import br.com.pessoal.productapi.entity.Supplier;
import br.com.pessoal.productapi.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public SupplierResponseDto create(SupplierFormDTO supplierForm) {
        var supplier = Supplier.builder().name(supplierForm.getName()).build();
        supplier = supplierRepository.save(supplier);
        return new SupplierResponseDto(supplier.getId(), supplier.getName());
    }

    public List<SupplierResponseDto> all() {
        return supplierRepository.all();
    }

    public SupplierResponseDto findById(Integer id) {
        var supplier = supplierRepository.getById(id);
        if (supplier == null) {
            throw new ServiceException("Supplier not found");
        }
        return new SupplierResponseDto(supplier.getId(), supplier.getName());
    }

    public SupplierResponseDto update(Integer id, SupplierFormDTO supplierForm) {
        var supplier = Supplier.builder().id(id).name(supplierForm.getName()).build();
        supplier = supplierRepository.save(supplier);
        return new SupplierResponseDto(supplier.getId(), supplier.getName());
    }

    public void delete(Integer id) {
        var supplier = supplierRepository.getById(id);
        if (supplier == null) {
            throw new ServiceException("Supplier not found");
        }
        supplierRepository.delete(supplier);
    }
}
