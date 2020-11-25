package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.model.Register;

import java.math.BigDecimal;
import java.util.List;

public interface RegisterService {
    void rechargeRegister(int registerId, BigDecimal amount);
    void transferBetweenRegisters(Transfer transfer);
    List<Register> getAll();
}
