/**
 * 
 */
package com.ss.sb.de;

import javax.persistence.*;

/**
 * @author heman
 *
 */

@Entity
@Table(name = "account_type")
public class AccountType {

	@Id
	private int account_type_id;
	private String account_type_desc;

	/**
	 * @return the account_type_id
	 */
	public int getAccount_type_id() {
		return account_type_id;
	}

	/**
	 * @param account_type_id the account_type_id to set
	 */
	public void setAccount_type_id(int account_type_id) {
		this.account_type_id = account_type_id;
	}

	/**
	 * @return the account_type_desc
	 */
	public String getAccount_type_desc() {
		return account_type_desc;
	}

	/**
	 * @param account_type_desc the account_type_desc to set
	 */
	public void setAccount_type_desc(String account_type_desc) {
		this.account_type_desc = account_type_desc;
	}

	@Override
	public String toString() {
		return "AccountType [account_type_id=" + account_type_id + ", account_type_desc=" + account_type_desc + "]";
	}

}
