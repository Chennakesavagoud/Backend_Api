package com.example.demoForApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoForApi.entity.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
