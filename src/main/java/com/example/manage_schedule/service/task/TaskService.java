package com.example.manage_schedule.service.task;

import com.example.manage_schedule.model.Task;
import com.example.manage_schedule.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository iTaskRepository;

    @Override
    public Iterable findAll() {
        return iTaskRepository.findAll();
    }

    @Override
    public void save(Task task) {
        iTaskRepository.save(task);
    }


    @Override
    public Optional findById(Long id) {
        return iTaskRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iTaskRepository.deleteById(id);
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return iTaskRepository.findAll(pageable);
    }

    @Override
    public Page<Task> findAllByFirstNameContaining(Pageable pageable, String name) {
        return iTaskRepository.findAllByFirstNameContaining(pageable,name);
    }
}
