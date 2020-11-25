package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.RegisterInfo;
import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.exception.NotEnoughMoneyException;
import com.rafal.in4mo.register.domain.exception.RegistryNotFoundException;
import com.rafal.in4mo.register.domain.model.Register;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import com.rafal.in4mo.register.domain.repository.TestInMemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterServiceImplTest {

    private RegisterRepository registerRepository;
    private RegisterService registerService;

    @BeforeEach
    public void initDB(){
        registerRepository =  new TestInMemoryRepository();
        registerRepository.save(new Register(1, "vacation", new BigDecimal(1000)));
        registerRepository.save(new Register(2, "food", new BigDecimal(200)));
        registerService = new RegisterServiceImpl(registerRepository);
    }

    @Test
    public void shouldReturnAll(){
        List<RegisterInfo> registersList = registerService.getAll().getRegistersList();
        assertThat(registersList).hasSize(2);
    }

    @Test
    public void shouldRechargeMoney() throws RegistryNotFoundException {
        registerService.rechargeRegister(1, new BigDecimal(500));
        assertThat(registerRepository.findById(1)).isPresent();
        assertThat(registerRepository.findById(1).get().getBalance()).isEqualTo(new BigDecimal(1500));
    }

    @Test
    public void shouldFailWhenRechargeWithWrongAccountNumber() {
        Assertions.assertThrows(RegistryNotFoundException.class,  () -> {
            registerService.rechargeRegister(15, new BigDecimal(500));
        });
        assertThat(registerRepository.findById(1).get().getBalance()).isEqualTo(new BigDecimal(1000));
        assertThat(registerRepository.findById(2).get().getBalance()).isEqualTo(new BigDecimal(200));
    }

    @Test
    public void shouldTransferMoney() throws RegistryNotFoundException, NotEnoughMoneyException {
        registerService.transferBetweenRegisters(new Transfer(1, 2, new BigDecimal(1000)));
        assertThat(registerRepository.findById(1).get().getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(registerRepository.findById(2).get().getBalance()).isEqualTo(new BigDecimal(1200));
    }

    @Test
    public void shouldFailWhenTransferWithWrongAccountNumber() {
        Assertions.assertThrows(RegistryNotFoundException.class, () -> {
            registerService.transferBetweenRegisters(new Transfer(1, 55, new BigDecimal(10)));
        });
        assertThat(registerRepository.findById(1).get().getBalance()).isEqualTo(new BigDecimal(1000));
        assertThat(registerRepository.findById(2).get().getBalance()).isEqualTo(new BigDecimal(200));
    }

    @Test
    public void shouldFailWhenTransferWithNotEnoughMoney() {
        Assertions.assertThrows(NotEnoughMoneyException.class, () -> {
            registerService.transferBetweenRegisters(new Transfer(1, 2, new BigDecimal(10000)));
        });
        assertThat(registerRepository.findById(1).get().getBalance()).isEqualTo(new BigDecimal(1000));
        assertThat(registerRepository.findById(2).get().getBalance()).isEqualTo(new BigDecimal(200));
    }


}