package com.example.manage.service;

import com.example.manage.model.ManageModel;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<ManageModel> getAllCategories();

    Optional<ManageModel> getCategoryById(Long id);

    ManageModel createCategory(ManageModel category);

    ManageModel updateCategory(Long id, ManageModel category);

    ManageModel patchCategory(Long id, ManageModel category);

    void deleteCategory(Long id);
}
