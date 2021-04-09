package com.ss.dayfour.assignmentfour;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LineTest {
	
	@Test
	void testGetSlope() {
		
		Line l = new Line(2.0, 3.0, 1.0, 5.0);
		assertEquals(l.getSlope(),1.0, 0.001);
	}

	@Test
	void testGetDistance() {
		
		Line l = new Line(2.0, 3.0, 1.0, 5.0);
		assertEquals(l.getDistance(),4.1231, 0.001);
	}

	@Test
	void testParallelTo() {
		
		Line l1 = new Line(2.0, 3.0, 1.0, 5.0);
		Line l2 = new Line(4.0, 6.0, 2.0, 10.0);
		Line l3 = new Line(1.0, 4.0, 7.0, 9.0);
		assertTrue(l1.parallelTo(l2));
		assertFalse(l1.parallelTo(l3));
	}

}
