package com.example.demoForApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demoForApi.entity.Laptop;
import com.example.demoForApi.service.LaptopService;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    // Save Laptop
    @PostMapping
    public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop) {
        return new ResponseEntity<>(laptopService.saveLaptop(laptop), HttpStatus.CREATED);
    }

    // Get all Laptops
    @GetMapping
    public ResponseEntity<List<Laptop>> getLaptops() {
        return new ResponseEntity<>(laptopService.getAllLaptops(), HttpStatus.OK);
    }

    // Get Laptop by ID
    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptop(@PathVariable int id) {
        Optional<Laptop> laptop = laptopService.getLaptopById(id);
        if (laptop.isPresent()) {
            return new ResponseEntity<>(laptop.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update Laptop
    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable int id, @RequestBody Laptop updatedLaptop) {
        Optional<Laptop> updated = laptopService.updateLaptop(id, updatedLaptop);
        if (updated.isPresent()) {
            return new ResponseEntity<>(updated.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Laptop
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable int id) {
        if (laptopService.deleteLaptop(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
