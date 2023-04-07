package com.EcommerceApplication.EcommerceApplication.Repository;

import com.EcommerceApplication.EcommerceApplication.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
