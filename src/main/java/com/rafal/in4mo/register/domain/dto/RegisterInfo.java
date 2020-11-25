package com.rafal.in4mo.register.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterInfo {
    private String name;
    private int id;
    private String amount;
}
