/**
 * 
 */
package com.ss.sb.de;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author heman
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	private int user_id;

	/**
	 * @return the id
	 */
	public int getUser_Id() {
		return user_id;
	}

	/**
	 * @param user_id the id to set
	 */
	public void setUser_Id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + "]";
	}
	
	

}
