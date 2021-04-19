/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class BookingGuest {

	private Booking booking;
	private String contactemail;
	private String contactphone;

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the contactemail
	 */
	public String getContactemail() {
		return contactemail;
	}

	/**
	 * @param contactemail the contactemail to set
	 */
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	/**
	 * @return the contactphone
	 */
	public String getContactphone() {
		return contactphone;
	}

	/**
	 * @param contactphone the contactphone to set
	 */
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	@Override
	public String toString() {
		return "BookingGuest [booking=" + booking + ", contactemail=" + contactemail + ", contactphone=" + contactphone
				+ "]";
	}

}
