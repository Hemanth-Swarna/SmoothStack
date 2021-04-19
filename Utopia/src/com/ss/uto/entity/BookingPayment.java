/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class BookingPayment {

	private Booking booking;
	private String stripeId;
	private boolean refunded;

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
	 * @return the stripeId
	 */
	public String getStripeId() {
		return stripeId;
	}

	/**
	 * @param stripeId the stripeId to set
	 */
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}

	/**
	 * @return the refunded
	 */
	public boolean isRefunded() {
		return refunded;
	}

	/**
	 * @param refunded the refunded to set
	 */
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}

	@Override
	public String toString() {
		return "BookingPayment [booking=" + booking + ", stripeId=" + stripeId + ", refunded=" + refunded + "]";
	}

}
