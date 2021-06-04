/**
 * 
 */
package com.ss.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sb.de.Account;
import com.ss.sb.service.AccountService;

/**
 * @author heman
 *
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountservice;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Account>> readAccounts() {
		return accountservice.getAllAccounts();
	}

}
