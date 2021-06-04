/**
 * 
 */
package com.ss.sb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sb.dao.AccountDAO;
import com.ss.sb.de.Account;

/**
 * @author heman
 *
 */
@Service
public class AccountService {

	@Autowired
	AccountDAO adao;

	public ResponseEntity<List<Account>> getAllAccounts(){
		List<Account> accounts = new ArrayList<>();
		adao.findAll().forEach(accounts::add);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

}
