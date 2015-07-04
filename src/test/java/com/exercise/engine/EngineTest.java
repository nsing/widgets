package com.exercise.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.exercise.engine.Engine;
import com.exercise.engine.EngineFactory;
import com.exercise.model.EngineType;
import com.exercise.model.FuelType;

/**
 * Engine tests.
 *
 */
public class EngineTest {
	
	Engine engine;

	@Before
	public void setUp() {
		engine = EngineFactory.getEngine(EngineType.INTERNAL_COMBUSTION, FuelType.PETROL); 
	}

    
    /**
     * Test engine fill with fuel level value -1.
     */
	@Test
	public void testEngineFillFailureLevelMinusOne() {
		engine.fill(FuelType.PETROL, -1);
		try {
			engine.start();
			fail("Engine cannot start with fuel level -1");
		}
		catch(IllegalStateException e) {
			//Do nothing
		}
	}
	
	/**
     * Test engine fill with fuel level value 0.
     */
	@Test
	public void testEngineFillFailureLevelZero() {
		engine.fill(FuelType.PETROL, 0);
		try {
			engine.start();
			fail("Engine cannot start with fuel level 0");
		}
		catch(IllegalStateException e) {
			//Do nothing
		}
	}
	
	/**
     * Test engine fill and start with fuel level value 50.
     */
	@Test
	public void testEngineFillSuccessLevelFifty() {
		engine.fill(FuelType.PETROL, 50);
		engine.start();
		assertTrue("Engine is not running", engine.isRunning());
	}
	
	/**
     * Test engine fill and start with fuel level value 100.
     */
	@Test
	public void testEngineFillSuccessLevelHundred() {
		engine.fill(FuelType.PETROL, 100);
		engine.start();
		assertTrue("Engine is not running", engine.isRunning());
	}
	
	/**
     * Test engine fill and start with fuel level value 150.
     */
	@Test
	public void testEngineFillSuccessLevelOneFifty() {
		engine.fill(FuelType.PETROL, 150);
		engine.start();
		assertTrue("Engine is not running", engine.isRunning());
	}
	
	/**
	 * Test engine stop.
	 */
	@Test
	public void testEngineStop() {
		engine.fill(FuelType.PETROL, 100);
		engine.start();
	    assertTrue("Engine is not running", engine.isRunning());
	    engine.stop();
	    assertTrue("Engine is running", !engine.isRunning());
	}
	

}
