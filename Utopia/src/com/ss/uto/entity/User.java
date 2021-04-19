/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class User {

	private int id;
	private UserRole userrole;
	private String givenname;
	private String familyname;
	private String username;
	private String email;
	private String password;
	private String phone;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userrole
	 */
	public UserRole getUserrole() {
		return userrole;
	}

	/**
	 * @param userrole the userrole to set
	 */
	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	/**
	 * @return the givenname
	 */
	public String getGivenname() {
		return givenname;
	}

	/**
	 * @param givenname the givenname to set
	 */
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	/**
	 * @return the familyname
	 */
	public String getFamilyname() {
		return familyname;
	}

	/**
	 * @param familyname the familyname to set
	 */
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userrole=" + userrole + ", givenname=" + givenname + ", familyname=" + familyname
				+ ", username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}

}
