/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.engine;

import com.exercise.model.EngineType;
import com.exercise.model.FuelType;

/**
 * Engine factory.
 *
 */
public class EngineFactory {

	/**
	 * Returns engine for a given engine type and fuel type.<br>
	 * Throws IllegalArgumentException in case engine type is not supported or
	 * there is invalid fuel type.
	 * 
	 * @param engineType
	 *            Engine type
	 * @param fuelType
	 *            Fuel type
	 * @return Appropriate instance of engine
	 */
	public static Engine getEngine(EngineType engineType, FuelType fuelType) {
		if (EngineType.INTERNAL_COMBUSTION == engineType) {
			return InternalCombustionEngine.getInstance(fuelType);
		} else if (EngineType.STEAM == engineType) {
			return SteamEngine.getInstance(fuelType);
		} else {
			throw new IllegalArgumentException();
		}
	}

}
