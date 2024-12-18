package com.example.demoForApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoForApi.entity.Laptop;
import com.example.demoForApi.repo.LaptopRepo;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;

    // Save Laptop
    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepo.save(laptop);
    }

    // Get all Laptops
    public List<Laptop> getAllLaptops() {
        return laptopRepo.findAll();
    }

    // Get Laptop by ID
    public Optional<Laptop> getLaptopById(int id) {
        return laptopRepo.findById(id);
    }

    // Update Laptop
    public Optional<Laptop> updateLaptop(int id, Laptop updatedLaptop) {
        Optional<Laptop> existingLaptop = laptopRepo.findById(id);
        if (existingLaptop.isPresent()) {
            Laptop laptop = existingLaptop.get();
            laptop.setLaptopName(updatedLaptop.getLaptopName());
            laptop.setLaptopPrice(updatedLaptop.getLaptopPrice());
            laptop.setLaptopDescription(updatedLaptop.getLaptopDescription());
            return Optional.of(laptopRepo.save(laptop));
        }
        return Optional.empty();
    }

    // Delete Laptop
    public boolean deleteLaptop(int id) {
        if (laptopRepo.existsById(id)) {
            laptopRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
