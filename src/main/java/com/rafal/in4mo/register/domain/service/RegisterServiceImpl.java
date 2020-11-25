package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.RegistersSummary;
import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public void rechargeRegister(int registerId, BigDecimal amount) {

    }

    @Override
    public void transferBetweenRegisters(Transfer transfer) {

    }

    @Override
    public RegistersSummary getAll() {
        return new RegistersSummary(registerRepository.findAll());
    }
}
