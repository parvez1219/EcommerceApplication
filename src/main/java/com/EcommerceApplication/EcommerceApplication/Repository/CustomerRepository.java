package com.EcommerceApplication.EcommerceApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.EcommerceApplication.EcommerceApplication.Model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
