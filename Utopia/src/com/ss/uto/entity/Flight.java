/**
 * 
 */
package com.ss.uto.entity;

import java.sql.Timestamp;

/**
 * @author heman
 *
 */
public class Flight {

	private int id;
	private Route route;
	private Airplane airplane;
	private Timestamp departure;
	private int reservedseats;
	private float seatprice;

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
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * @return the airplane
	 */
	public Airplane getAirplane() {
		return airplane;
	}

	/**
	 * @param airplane the airplane to set
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	/**
	 * @return the departure
	 */
	public Timestamp getDeparture() {
		return departure;
	}

	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}

	/**
	 * @return the reservedseats
	 */
	public int getReservedSeats() {
		return reservedseats;
	}

	/**
	 * @param reservedseats the reserved_seats to set
	 */
	public void setReservedSeats(int reservedseats) {
		this.reservedseats = reservedseats;
	}

	/**
	 * @return the seatprice
	 */
	public float getSeatPrice() {
		return seatprice;
	}

	/**
	 * @param seatprice the seat_price to set
	 */
	public void setSeatPrice(float seatprice) {
		this.seatprice = seatprice;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", route=" + route + ", airplane=" + airplane + ", departure=" + departure
				+ ", reserved_seats=" + reservedseats + ", seat_price=" + seatprice + "]";
	}

}
