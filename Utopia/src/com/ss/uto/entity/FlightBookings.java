/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class FlightBookings {

	private Flight flight;
	private Booking booking;

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

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

	@Override
	public String toString() {
		return "FlightBookings [flight=" + flight + ", booking=" + booking + "]";
	}

}
