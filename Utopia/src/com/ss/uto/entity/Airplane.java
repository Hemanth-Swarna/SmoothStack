/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class Airplane {

	private int id;
	private AirplaneType type;

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
	 * @return the type
	 */
	public AirplaneType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(AirplaneType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", type=" + type + "]";
	}

}
