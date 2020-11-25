package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.RegistersSummary;
import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.exception.RegistryNotFoundException;
import com.rafal.in4mo.register.domain.model.Register;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    @Transactional
    public void rechargeRegister(int registerId, BigDecimal amount) throws RegistryNotFoundException {
        Optional<Register> register = registerRepository.findById(registerId);
        if (register.isEmpty()) {
            throw new RegistryNotFoundException("Not found");
        }
        register.get().increaseBalance(amount);
    }

    @Override
    public void transferBetweenRegisters(Transfer transfer) {

    }

    @Override
    public RegistersSummary getAll() {
        return new RegistersSummary(registerRepository.findAll());
    }
}
