package com.example.manage_schedule.repository;

import com.example.manage_schedule.model.Category;
import com.example.manage_schedule.model.DTO.CountAmount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Long> {
    @Query(nativeQuery = true, value = "select category.nameC, sum(task.amount) as total_money from category join task on category.id = task.category_id group by category.namec;")
    Iterable<CountAmount> getTotal();


}
