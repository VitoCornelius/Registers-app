package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.model.Register;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Override
    public void rechargeRegister(int registerId, BigDecimal amount) {

    }

    @Override
    public void transferBetweenRegisters(Transfer transfer) {

    }

    @Override
    public List<Register> getAll() {
        return null;
    }
}
