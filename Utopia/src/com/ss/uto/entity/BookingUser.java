/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class BookingUser {

	private Booking booking;
	private User user;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "BookingUser [booking=" + booking + ", user=" + user + "]";
	}
	
	
	
}
