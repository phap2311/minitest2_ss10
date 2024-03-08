package com.example.manage_schedule.service.category;

import com.example.manage_schedule.model.Category;
import com.example.manage_schedule.model.DTO.CountAmount;
import com.example.manage_schedule.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Iterable findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Optional findById(Long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Iterable<CountAmount> totalAmount() {
        return iCategoryRepository.getTotal();
    }
}
