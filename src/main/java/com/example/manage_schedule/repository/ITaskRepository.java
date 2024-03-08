package com.example.manage_schedule.repository;

import com.example.manage_schedule.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task,Long> {

}
