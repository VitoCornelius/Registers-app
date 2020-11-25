package com.rafal.in4mo.register.domain.repository;

import com.rafal.in4mo.register.domain.model.Register;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class TestInMemoryRepository implements RegisterRepository {

    List<Register> registers = new ArrayList<>();

    @Override
    public List<Register> findAll() {
        return registers;
    }

    @Override
    public Register findById(int id) {
        return registers.stream().filter(register -> register.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Register register) {
        registers.add(register);
    }
}
