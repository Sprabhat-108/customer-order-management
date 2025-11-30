package com.prabhat.customerorder.management.service.impl;



import com.prabhat.customerorder.management.exception.ResourceNotFoundException;
import com.prabhat.customerorder.management.model.Customer;
import com.prabhat.customerorder.management.repository.CustomerRepository;
import com.prabhat.customerorder.management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor   // Lombok generates constructor for final fields
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        // You can add business validations here (eg: unique email check)
        return repository.save(customer);
    }

    @Transactional
    @Override
    public Optional<Customer> update(Long id, Customer updated) {
        return repository.findById(id).map(existing -> {
            // update fields explicitly (avoid replacing whole entity unless intentional)
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setPhone(updated.getPhone());
            return repository.save(existing);
        });
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

