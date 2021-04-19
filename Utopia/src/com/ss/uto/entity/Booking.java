/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class Booking {

	private int id;
	private boolean isactive;
	private String confirmationcode;

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
	 * @return the isactive
	 */
	public boolean isIsActive() {
		return isactive;
	}

	/**
	 * @param isactive the isactive to set
	 */
	public void setIsActive(boolean isactive) {
		this.isactive = isactive;
	}

	/**
	 * @return the confirmationcode
	 */
	public String getConfirmationCode() {
		return confirmationcode;
	}

	/**
	 * @param confirmationcode the confirmation_code to set
	 */
	public void setConfirmationCode(String confirmationcode) {
		this.confirmationcode = confirmationcode;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", isactive=" + isactive + ", confirmationcode=" + confirmationcode + "]";
	}

}
