package com.example.manage_schedule.service;

import java.util.Optional;

public interface IGenerateService<C> {
    Iterable<C> findAll();

    void save(C c);

    Optional<C> findById(Long id);

    void remove(Long id);
}
