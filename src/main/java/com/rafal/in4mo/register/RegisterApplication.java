package com.rafal.in4mo.register;

import com.rafal.in4mo.register.domain.model.Register;
import com.rafal.in4mo.register.domain.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
public class RegisterApplication {

	@Autowired
	RegisterRepository registerRepository;

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}

	@PostConstruct
	public void run(){
		if (registerRepository.findById(1).isEmpty()) registerRepository.save(new Register(1, "Wallet", new BigDecimal(1000)));
		if (registerRepository.findById(2).isEmpty()) registerRepository.save(new Register(2, "Savings", new BigDecimal(5000)));
		if (registerRepository.findById(3).isEmpty()) registerRepository.save(new Register(3, "Insurance Policy", new BigDecimal(0)));
		if (registerRepository.findById(4).isEmpty()) registerRepository.save(new Register(4, "Food Expenses", new BigDecimal(0)));
	}

}
