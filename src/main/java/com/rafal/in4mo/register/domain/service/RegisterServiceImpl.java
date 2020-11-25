package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.RegistersSummary;
import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.exception.NotEnoughMoneyException;
import com.rafal.in4mo.register.domain.exception.RegistryNotFoundException;
import com.rafal.in4mo.register.domain.model.Register;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    @Transactional
    public void rechargeRegister(int registerId, BigDecimal amount) throws RegistryNotFoundException {
        Optional<Register> register = registerRepository.findById(registerId);
        if (register.isEmpty()) {
            throw new RegistryNotFoundException("Register not found");
        }
        register.get().increaseBalance(amount);
    }

    @Override
    @Transactional
    public void transferBetweenRegisters(Transfer transfer) throws RegistryNotFoundException, NotEnoughMoneyException {
        BigDecimal amountToBeTransferred = transfer.getAmount();
        Optional<Register> fromRegister = registerRepository.findById(transfer.getFromRegisterId());
        Optional<Register> toRegister = registerRepository.findById(transfer.getToRegisterId());

        if (fromRegister.isPresent() && toRegister.isPresent()) {
            transferMoney(fromRegister.get(), toRegister.get(), amountToBeTransferred);
        } else {
            throw new RegistryNotFoundException("Register not found");
        }
    }

    private void transferMoney(Register fromRegister, Register toRegister, BigDecimal amountToBeTransferred) throws NotEnoughMoneyException {
        if (fromRegister.getBalance().compareTo(amountToBeTransferred) >= 0) {
            fromRegister.substractbalance(amountToBeTransferred);
            toRegister.increaseBalance(amountToBeTransferred);
        } else {
            throw new NotEnoughMoneyException("Not enough money to transfer!");
        }
    }

    @Override
    public RegistersSummary getAll() {
        return new RegistersSummary(registerRepository.findAll());
    }
}
