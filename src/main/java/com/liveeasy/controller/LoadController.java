package com.liveeasy.controller;

import com.liveeasy.entity.Load;
import com.liveeasy.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loads")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @PostMapping("/load")
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        // Perform save operation using loadRepository
//        http://localhost:8080/loads/load
        loadRepository.save(load);
        return ResponseEntity.ok("Loads details added successfully");
    }

    @GetMapping("/load")
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        // Perform query using loadRepository
//        http://localhost:8080/loads/load?shipperId=shipper123
        List<Load> loads = loadRepository.findByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        // Perform get load query using loadRepository
//        http://localhost:8080/loads/load/1
        Load load = loadRepository.findById(loadId).orElse(null);
        if (load == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(load);
    }

    @PutMapping("/load/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
        // Perform update operation using loadRepository
//        http://localhost:8080/loads/load/1
        Load existingLoad = loadRepository.findById(loadId).orElse(null);
        if (existingLoad == null) {
            return ResponseEntity.notFound().build();
        }


        if (updatedLoad.getLoadingPoint() != null) {
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
        }
        // Update other fields...

        loadRepository.save(existingLoad);
        return ResponseEntity.ok(existingLoad);
    }

    @DeleteMapping("/load/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        // Perform delete operation using loadRepository
//        http://localhost:8080/loads/load/1
        loadRepository.deleteById(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}
