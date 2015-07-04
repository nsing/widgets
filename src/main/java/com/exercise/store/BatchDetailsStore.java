/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.store;

import java.math.BigDecimal;

/**
 * BatchDetailsStore interface having batch details related functions.
 *
 */
public interface BatchDetailsStore {

	/**
	 * Returns batch cost for a given fuel type.
	 * 
	 * @param fuelType
	 *            Fuel type
	 * @return Batch cost for the given fuel type
	 */
	BigDecimal getCost(String fuelType);

	/**
	 * Returns batch size for a given engine type.
	 * 
	 * @param engineType
	 *            Engine type
	 * @return Batch size for the given engine type
	 */
	Integer getSize(String engineType);

}
