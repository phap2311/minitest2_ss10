package com.example.manage_schedule.service.category;

import com.example.manage_schedule.model.Category;
import com.example.manage_schedule.model.DTO.CountAmount;
import com.example.manage_schedule.service.IGenerateService;

public interface ICategoryService extends IGenerateService<Category>{
    Iterable<CountAmount>totalAmount();

}
