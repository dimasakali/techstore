package com.DmVaAlex.techstore.service;

import com.DmVaAlex.techstore.entity.Category;
import com.DmVaAlex.techstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Категория с id " + id + " не найдена"));
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category existing = getById(id);
        existing.setName(category.getName());
        return categoryRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        categoryRepository.deleteById(id);
    }
}