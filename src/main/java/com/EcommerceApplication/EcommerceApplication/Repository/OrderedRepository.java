package com.EcommerceApplication.EcommerceApplication.Repository;

import com.EcommerceApplication.EcommerceApplication.Model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {
}
