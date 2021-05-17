/**
 * 
 */
package com.ss.sb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sb.de.Account;

/**
 * @author heman
 *
 */
public interface AccountDAO extends JpaRepository<Account, Integer>{

}
