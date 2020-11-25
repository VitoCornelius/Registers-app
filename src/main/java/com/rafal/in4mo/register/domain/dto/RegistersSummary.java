package com.rafal.in4mo.register.domain.dto;

import com.rafal.in4mo.register.domain.model.Register;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistersSummary {
    List<RegisterInfo> registersList = new ArrayList<>();

    public RegistersSummary(List<Register> registers) {
        registers.forEach(register -> registersList.add(RegisterInfo.mapToRegisterInfo(register.getName(), register.getBalance(), register.getId())));
    }
}
