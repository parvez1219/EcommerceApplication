package com.EcommerceApplication.EcommerceApplication.Repository;

import com.EcommerceApplication.EcommerceApplication.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
}