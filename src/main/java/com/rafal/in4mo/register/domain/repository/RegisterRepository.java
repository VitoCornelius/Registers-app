package com.rafal.in4mo.register.domain.repository;

import com.rafal.in4mo.register.domain.model.Register;

import java.util.List;

public interface RegisterRepository {
    List<Register> findAll();
    Register findById(int id);
    void save(Register register);
}
