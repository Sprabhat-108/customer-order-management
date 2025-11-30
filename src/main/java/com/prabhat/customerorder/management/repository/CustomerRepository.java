package com.prabhat.customerorder.management.repository;


import com.prabhat.customerorder.management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // add custom queries if needed, e.g. Optional<Customer> findByEmail(String email);
}

