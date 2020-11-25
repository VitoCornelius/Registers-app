package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.RegistersSummary;
import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.exception.NotEnoughMoneyException;
import com.rafal.in4mo.register.domain.exception.RegistryNotFoundException;

import java.math.BigDecimal;

public interface RegisterService {
    void rechargeRegister(int registerId, BigDecimal amount) throws RegistryNotFoundException;
    void transferBetweenRegisters(Transfer transfer) throws RegistryNotFoundException, NotEnoughMoneyException;
    RegistersSummary getAll();
}
