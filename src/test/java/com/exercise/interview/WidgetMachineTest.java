/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.interview;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.BeforeClass;

import com.exercise.WidgetMachine;
import com.exercise.engine.Engine;
import com.exercise.engine.EngineFactory;
import com.exercise.model.EngineType;
import com.exercise.model.FuelType;
import com.exercise.store.BatchDetailsStoreProperties;

/**
 * Widget machine test.
 *
 */
public class WidgetMachineTest {

	static WidgetMachine<Engine, BatchDetailsStoreProperties> widgetMachine;

	@BeforeClass
	public static void setUp() {
		widgetMachine = new WidgetMachine<Engine, BatchDetailsStoreProperties>();
		widgetMachine.setBatchStore(new BatchDetailsStoreProperties());
	}

	/**
	 * Test internal combustion engine with petrol.
	 */
	@Test
	public void testInternalCombustionPetrol() {
		widgetMachine.setEngine(EngineFactory.getEngine(
				EngineType.INTERNAL_COMBUSTION, FuelType.PETROL));
		assertEquals(new BigDecimal("18.00"), widgetMachine.produceWidgets(10));
	}

	/**
	 * Test internal combustion engine with diesel.
	 */
	@Test
	public void testInternalCombustionDiesel() {
		widgetMachine.setEngine(EngineFactory.getEngine(
				EngineType.INTERNAL_COMBUSTION, FuelType.DIESEL));
		assertEquals(new BigDecimal("24.00"), widgetMachine.produceWidgets(10));
	}

	/**
	 * Test internal combustion engine with wood.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInternalCombustionWood() {
		widgetMachine.setEngine(EngineFactory.getEngine(
				EngineType.INTERNAL_COMBUSTION, FuelType.WOOD));
	}

	/**
	 * Test internal combustion engine with coal.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInternalCombustionCoal() {
		widgetMachine.setEngine(EngineFactory.getEngine(
				EngineType.INTERNAL_COMBUSTION, FuelType.COAL));
	}

	/**
	 * Test steam engine with wood.
	 */
	@Test
	public void testSteamWood() {
		widgetMachine.setEngine(EngineFactory.getEngine(EngineType.STEAM,
				FuelType.WOOD));
		assertEquals(new BigDecimal("21.75"), widgetMachine.produceWidgets(10));
	}

	/**
	 * Test steam engine with coal.
	 */
	@Test
	public void testSteamCoal() {
		widgetMachine.setEngine(EngineFactory.getEngine(EngineType.STEAM,
				FuelType.COAL));
		assertEquals(new BigDecimal("28.25"), widgetMachine.produceWidgets(10));
	}

	/**
	 * Test steam engine with petrol.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSteamPetrol() {
		widgetMachine.setEngine(EngineFactory.getEngine(EngineType.STEAM,
				FuelType.PETROL));
	}

	/**
	 * Test steam engine with diesel.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSteamDiesel() {
		widgetMachine.setEngine(EngineFactory.getEngine(EngineType.STEAM,
				FuelType.DIESEL));
	}

	/**
	 * Test null engine with diesel.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullDiesel() {
		widgetMachine.setEngine(EngineFactory.getEngine(null,
				FuelType.DIESEL));
	}
	
	/**
	 * Test null engine with null fuel.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullNull() {
		widgetMachine.setEngine(EngineFactory.getEngine(null, null));
	}
}
