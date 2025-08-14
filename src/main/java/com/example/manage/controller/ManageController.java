package com.example.manage.controller;

import com.example.manage.model.ManageModel;
import com.example.manage.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Manage")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @GetMapping
    public List<ManageModel> getAllCategories() {
        return manageService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManageModel> getCategoryById(@PathVariable Long id) {
        return manageService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ManageModel createCategory(@RequestBody ManageModel category) {
        return manageService.createCategory(category);
    }

    @PutMapping("/{id}")
    public ManageModel updateCategory(@PathVariable Long id, @RequestBody ManageModel category) {
        return manageService.updateCategory(id, category);
    }

    @PatchMapping("/{id}")
    public ManageModel patchCategory(@PathVariable Long id, @RequestBody ManageModel category) {
        return manageService.patchCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        manageService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
