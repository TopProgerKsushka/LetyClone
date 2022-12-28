package com.example.springapp.letyclone.repository;

import com.example.springapp.letyclone.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Shop findByName(String name);
}
