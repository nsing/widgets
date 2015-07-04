/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.store;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * Implementation of BatchDetailsStore getting data through properties files.
 * 
 */
public class BatchDetailsStoreProperties implements BatchDetailsStore {

	/** Fuel batch cost */
	private Properties costCache = new Properties();

	/** Engine batch size */
	private Properties sizeCache = new Properties();

	/** Constructor initialising caches */
	public BatchDetailsStoreProperties() {
		try {
			costCache.load(getClass().getClassLoader().getResourceAsStream(
					"costs.properties"));
			sizeCache.load(getClass().getClassLoader().getResourceAsStream(
					"sizes.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BigDecimal getCost(String fuelType) {
		return new BigDecimal(costCache.getProperty(fuelType));
	}

	@Override
	public Integer getSize(String engineType) {
		return Integer.valueOf(sizeCache.getProperty(engineType));
	}

}
