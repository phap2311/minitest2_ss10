package com.example.manage_schedule.service.task;

import com.example.manage_schedule.model.Task;
import com.example.manage_schedule.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaskService extends IGenerateService<Task> {
Page<Task>findAll(Pageable pageable);
Page<Task>findAllByFirstNameContaining(Pageable pageable, String name);
}
