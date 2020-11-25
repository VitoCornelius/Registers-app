package com.rafal.in4mo.register.infrastructure;

import com.rafal.in4mo.register.domain.model.Register;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaRegisterRepository extends JpaRepository<Register, Integer>, RegisterRepository {
    List<Register> findAll();
    Optional<Register> findById(int id);
}
