package com.example.manage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class ManageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String description;
    private Integer itemsCount;

    @ElementCollection
    @CollectionTable(name = "category_actions", joinColumns = @JoinColumn(name = "category_id"))
    @Column(name = "action")
    private List<String> actions;

    // Constructors
    public ManageModel() {}
    public ManageModel(String categoryName, String description, Integer itemsCount, List<String> actions) {
        this.categoryName = categoryName;
        this.description = description;
        this.itemsCount = itemsCount;
        this.actions = actions;
    }

    // Getters & Setters
    public Long getId() { return id; }
    
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getItemsCount() { return itemsCount; }
    public void setItemsCount(Integer itemsCount) { this.itemsCount = itemsCount; }
    public List<String> getActions() { return actions; }
    public void setActions(List<String> actions) { this.actions = actions; }
}
