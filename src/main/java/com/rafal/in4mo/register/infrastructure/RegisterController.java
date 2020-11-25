package com.rafal.in4mo.register.infrastructure;

import com.rafal.in4mo.register.domain.dto.RegistersSummary;
import com.rafal.in4mo.register.domain.dto.Transfer;
import com.rafal.in4mo.register.domain.exception.NotEnoughMoneyException;
import com.rafal.in4mo.register.domain.exception.RegistryNotFoundException;
import com.rafal.in4mo.register.domain.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
@RequestMapping("registers")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/")
    @ResponseBody
    public RegistersSummary getAllRegisters() {
        return registerService.getAll();
    }

    @PutMapping("{registerId}")
    public void recharge(@PathVariable(name = "registerId") int registerId, @RequestParam(name = "amount") double amount) {
        try {
            this.registerService.rechargeRegister(registerId, new BigDecimal(amount));
        } catch (RegistryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registry not Found", e);
        }
    }

    @PostMapping("transfer")
    public void transfer(@RequestBody Transfer transfer){
        try {
            this.registerService.transferBetweenRegisters(transfer);
        } catch (NotEnoughMoneyException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough money on the account", e);
        } catch (RegistryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registry not found", e);
        }
    }

}