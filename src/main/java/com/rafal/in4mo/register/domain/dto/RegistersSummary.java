package com.rafal.in4mo.register.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistersSummary {
    List<RegisterInfo> registerInfoList = new ArrayList<>();
}
