package com.bsoftgroup.springcloudmspago.repository;

import com.bsoftgroup.springcloudmspago.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
