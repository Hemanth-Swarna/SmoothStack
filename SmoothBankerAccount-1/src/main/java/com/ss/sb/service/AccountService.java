/**
 * 
 */
package com.ss.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Account> getAllAccounts(){
		List<Account> accounts = new ArrayList<>();
		adao.findAll().forEach(accounts::add);
		return accounts;
	}

}
