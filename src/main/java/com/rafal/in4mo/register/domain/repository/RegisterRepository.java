package com.rafal.in4mo.register.domain.repository;

import com.rafal.in4mo.register.domain.model.Register;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository {
    List<Register> findAll();
    Optional<Register> findById(int id);
    Register save(Register register);
}
