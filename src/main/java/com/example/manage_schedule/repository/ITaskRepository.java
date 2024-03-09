package com.example.manage_schedule.repository;

import com.example.manage_schedule.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {
    Page<Task> findAll(Pageable pageable);

    Page<Task> findAllByFirstNameContaining(Pageable pageable, String name);
}
