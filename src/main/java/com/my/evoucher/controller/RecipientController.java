package com.my.evoucher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.evoucher.domain.Recipient;
import com.my.evoucher.exception.RecipientEmailExistException;
import com.my.evoucher.repository.RecipientRepository;

@RestController()
@RequestMapping("recipient")
public class RecipientController {

	@Autowired
	RecipientRepository recipientRepository;
	
	@GetMapping("/all")
	public List<Recipient> getAllRecipient(){
		return recipientRepository.findAll();
	}
	
	@GetMapping("/search/{email}")
	public Recipient findByEmail(@PathVariable String email) {
		return recipientRepository.findByEmail(email);
	}
	
	@PostMapping("/{name}/{email}")
	public Recipient insertRecipient(@PathVariable String name, @PathVariable String email) {
		
		try {
			return recipientRepository.save(new Recipient(name,email));
		} catch (Exception e) {
			throw new RecipientEmailExistException();
		}
	}
	
	
}
