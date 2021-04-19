/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class Airport {
	
	private String airportCode;
	private String cityName;
	/**
	 * @return the airportCode
	 */
	public String getAirportCode() {
		return airportCode;
	}
	/**
	 * @param airportCode the airportCode to set
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", cityName=" + cityName + "]";
	}

}
