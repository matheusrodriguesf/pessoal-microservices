package br.com.pessoal.productapi.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.pessoal.productapi.dto.SupplierForm;
import br.com.pessoal.productapi.dto.SupplierResponse;
import br.com.pessoal.productapi.entity.Supplier;
import br.com.pessoal.productapi.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public SupplierResponse create(SupplierForm supplierForm) {
        var supplier = Supplier.builder().name(supplierForm.name()).build();
        supplier = supplierRepository.save(supplier);
        return new SupplierResponse(supplier.getId(), supplier.getName());
    }

    public List<SupplierResponse> all() {
        return supplierRepository.all();
    }

    public SupplierResponse findById(Integer id) {
        var supplier = supplierRepository.getById(id);
        if (supplier == null) {
            throw new ServiceException("Supplier not found");
        }
        return new SupplierResponse(supplier.getId(), supplier.getName());
    }

    public SupplierResponse update(Integer id, SupplierForm supplierForm) {
        var supplier = Supplier.builder().id(id).name(supplierForm.name()).build();
        supplier = supplierRepository.save(supplier);
        return new SupplierResponse(supplier.getId(), supplier.getName());
    }

    public void delete(Integer id) {
        var supplier = supplierRepository.getById(id);
        if (supplier == null) {
            throw new ServiceException("Supplier not found");
        }
        supplierRepository.delete(supplier);
    }
}
