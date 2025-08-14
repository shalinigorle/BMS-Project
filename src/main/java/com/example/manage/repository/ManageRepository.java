package com.example.manage.repository;

import com.example.manage.model.ManageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageRepository extends JpaRepository<ManageModel, Long> {
}
