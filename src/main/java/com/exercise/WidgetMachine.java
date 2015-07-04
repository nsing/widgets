/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise;

import java.math.BigDecimal;

import com.exercise.engine.Engine;
import com.exercise.store.BatchDetailsStore;

/**
 * Widget machine.
 *
 */
public class WidgetMachine<T extends Engine, S extends BatchDetailsStore> {

	/** Engine */
	private T engine;

	/** Batch details store */
	private S batchDetailsStore;

	/**
	 * Sets engine.
	 * 
	 * @param engine
	 *            Engine
	 */
	public void setEngine(T engine) {
		this.engine = engine;
	}

	/**
	 * Sets batch details store.
	 * 
	 * @param batchDetailsStore
	 *            Batch details store
	 */
	public void setBatchStore(S batchDetailsStore) {
		this.batchDetailsStore = batchDetailsStore;
	}

	/**
	 * Fills, starts and stops the engine. And returns cost involved with given
	 * quantity.
	 * 
	 * @param quantity
	 *            Quantity
	 * @return Cost
	 */
	public BigDecimal produceWidgets(int quantity) {
		engine.fill(engine.getFuelType(), 100); // Needed otherwise engine won't start
		engine.start();
		BigDecimal cost = new BigDecimal("0.00");
		if (engine.isRunning()) {
			cost = produce(quantity);
			engine.stop();
		}
		return cost;
	}

	/**
	 * Returns cost involved with the given quantity.
	 * 
	 * @param quantity
	 *            Quantity
	 * @return Cost
	 */
	private BigDecimal produce(int quantity) {
		int batch = 0;
		int batchCount = 0;
		BigDecimal costPerBatch;
		costPerBatch = batchDetailsStore.getCost(engine.getFuelType().name());
		while (batch < quantity) {
			batch += batchDetailsStore.getSize(engine.getEngineType().name());
			batchCount++;
		}
		return costPerBatch.multiply(new BigDecimal(batchCount));
	}

}
