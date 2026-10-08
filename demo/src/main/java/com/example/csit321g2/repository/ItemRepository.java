package com.example.csit321g2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.csit321g2.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{
}

