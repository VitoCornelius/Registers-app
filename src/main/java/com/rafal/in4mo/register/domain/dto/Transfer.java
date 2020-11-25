package com.rafal.in4mo.register.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Transfer {
    private int fromRegisterId;
    private int toRegisterId;
    private BigDecimal amount;
}
