package com.rafal.in4mo.register.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Setter
@AllArgsConstructor
public class RegisterInfo {
    private String name;
    private int id;
    private String amount;

    public static RegisterInfo mapToRegisterInfo(String registerName, BigDecimal amount, int registerId) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        String result = df.format(amount);
        return new RegisterInfo(registerName, registerId, result);
    }
}
