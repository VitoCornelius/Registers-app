package com.rafal.in4mo.register.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal balance = BigDecimal.ZERO;

    //private List<RegisterEvent> registerEventList = new ArrayList<>(); //TODO

    public void increaseBalance(BigDecimal amount) {
        //TODO add an domain event handling mechanism to hold the history of operations :)
        this.balance = this.balance.add(amount);
    }

    public void substractbalance(BigDecimal amount) {
        //TODO add an domain event handling mechanism to hold the history of operations :)
        this.balance = this.balance.subtract(amount);
    }

}
