package com.prabhat.customerorder.management.service;

import com.prabhat.customerorder.management.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    @Transactional
    Customer save(Customer customer);

    @Transactional
    Optional<Customer> update(Long id, Customer updated);

    @Transactional
    void delete(Long id);
}
