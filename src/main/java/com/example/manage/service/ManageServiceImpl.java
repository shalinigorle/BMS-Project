package com.example.manage.service;

import com.example.manage.model.ManageModel;
import com.example.manage.repository.ManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private ManageRepository repository;

    @Override
    public List<ManageModel> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Optional<ManageModel> getCategoryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ManageModel createCategory(ManageModel category) {
        return repository.save(category);
    }

    @Override
    public ManageModel updateCategory(Long id, ManageModel category) {
        ManageModel existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setCategoryName(category.getCategoryName());
        existing.setDescription(category.getDescription());
        existing.setItemsCount(category.getItemsCount());
        existing.setActions(category.getActions());
        return repository.save(existing);
    }

    @Override
    public ManageModel patchCategory(Long id, ManageModel category) {
        ManageModel existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        if (category.getCategoryName() != null) existing.setCategoryName(category.getCategoryName());
        if (category.getDescription() != null) existing.setDescription(category.getDescription());
        if (category.getItemsCount() != null) existing.setItemsCount(category.getItemsCount());
        if (category.getActions() != null) existing.setActions(category.getActions());
        return repository.save(existing);
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
