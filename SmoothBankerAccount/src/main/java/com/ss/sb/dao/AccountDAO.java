/**
 * 
 */
package com.ss.sb.dao;

import com.ss.sb.de.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heman
 *
 */
public interface AccountDAO extends JpaRepository<Account, Integer>{

}
