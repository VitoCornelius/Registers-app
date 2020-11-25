package com.rafal.in4mo.register.domain.service;

import com.rafal.in4mo.register.domain.dto.RegisterInfo;
import com.rafal.in4mo.register.domain.model.Register;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import com.rafal.in4mo.register.domain.repository.TestInMemoryRepository;
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

}