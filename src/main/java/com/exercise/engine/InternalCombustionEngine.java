/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.engine;

import com.exercise.model.EngineType;
import com.exercise.model.FuelType;

/**
 * Internal combustion engine.
 *
 */
public class InternalCombustionEngine extends Engine {

	/**
	 * Constructor with fuel type.<br>
	 * It is private because instance is returned through getInstance method call.<br>
	 *  
	 * @param fuelType Fuel type
	 */
	private InternalCombustionEngine(FuelType fuelType) {
		super(EngineType.INTERNAL_COMBUSTION, fuelType);
	}

	/**
	 * Returns internal combustion engine implementation for a given fuel type.<br>
	 * Throws IllegalArgumentException in case fuel type is not supported.
	 * 
	 * @param fuelType Fuel type
	 * @return Internal combustion engine
	 */
	public static Engine getInstance(FuelType fuelType) {
		if (FuelType.PETROL == fuelType
				|| FuelType.DIESEL == fuelType) {
			return new InternalCombustionEngine(fuelType);
		}
		throw new IllegalArgumentException();
	}

}
