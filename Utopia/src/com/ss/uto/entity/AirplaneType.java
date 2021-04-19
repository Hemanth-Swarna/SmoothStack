/**
 * 
 */
package com.ss.uto.entity;

/**
 * @author heman
 *
 */
public class AirplaneType {

	private int id;
	private int max_capacity;

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
	 * @return the max_capacity
	 */
	public int getMax_capacity() {
		return max_capacity;
	}

	/**
	 * @param max_capacity the max_capacity to set
	 */
	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	@Override
	public String toString() {
		return "AirplaneType [id=" + id + ", max_capacity=" + max_capacity + "]";
	}

}
