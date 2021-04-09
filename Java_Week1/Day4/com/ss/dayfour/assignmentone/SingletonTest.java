/**
 * 
 */
package com.ss.dayfour.assignmentone;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;



/**
 * @author heman
 *
 */
public class SingletonTest {

	@Test
	void getInstance() {
        Singleton test = Singleton.getInstance();
        assertNotNull(test);
    }
}
