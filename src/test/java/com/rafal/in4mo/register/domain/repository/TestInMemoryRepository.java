package com.rafal.in4mo.register.domain.repository;

import com.rafal.in4mo.register.domain.model.Register;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestInMemoryRepository implements RegisterRepository {

    List<Register> registers = new ArrayList<>();

    @Override
    public List<Register> findAll() {
        return registers;
    }

    @Override
    public Optional<Register> findById(int id) {
        return registers.stream().filter(register -> register.getId() == id).findFirst();
    }

    @Override
    public Register save(Register register) {
        registers.add(register);
        return register;
    }
}
