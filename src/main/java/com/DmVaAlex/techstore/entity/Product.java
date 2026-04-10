package com.DmVaAlex.techstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название товара не может быть пустым")
    private String name;

    private String description;

    @NotNull(message = "Цена не может быть пустой")
    @Min(value = 0, message = "Цена не может быть отрицательной")
    private Double price;

    @NotNull(message = "Количество не может быть пустым")
    @Min(value = 0, message = "Количество не может быть отрицательным")
    private Integer stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}