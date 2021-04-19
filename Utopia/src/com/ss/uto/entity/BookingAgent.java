/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class BookingAgent {

	private Booking booking;
	private User agent;

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
	 * @return the agent
	 */
	public User getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(User agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "BookingAgent [booking=" + booking + ", agent=" + agent + "]";
	}

}
