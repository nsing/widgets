/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.engine;

import com.exercise.model.EngineType;
import com.exercise.model.FuelType;

/**
 * Steam engine.
 *
 */
public class SteamEngine extends Engine {

	/**
	 * Constructor with fuel type.<br>
	 * It is private because instance is returned through getInstance method call.<br>
	 *  
	 * @param fuelType Fuel type
	 */
	private SteamEngine(FuelType fuelType) {
		super(EngineType.STEAM, fuelType);
	}

	/**
	 * Returns steam engine implementation for a given fuel type.<br>
	 * Throws IllegalArgumentException in case fuel type is not supported.
	 * 
	 * @param fuelType Fuel type
	 * @return Steam engine
	 */
	public static SteamEngine getInstance(FuelType fuelType) {
		if (FuelType.COAL == fuelType
				|| FuelType.WOOD == fuelType) {
			return new SteamEngine(fuelType);
		}
		throw new IllegalArgumentException();
	}

}
