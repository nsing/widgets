/**********************************************************************
 * This source code is the property of Lloyds Banking Group PLC.
 *
 * All Rights Reserved.
 ***********************************************************************/
package com.exercise.engine;

import com.exercise.model.EngineType;
import com.exercise.model.FuelType;

/**
 * Abstract engine.
 *
 */
public abstract class Engine {
	
	/** Flag indicating whether engine is running or not. */
    private boolean running;
    
    /** Engine fuel level. */
    private int fuelLevel;
    
    /** Required fuel type for the engine. */
    private FuelType requiredFuelType;
    
    /** Filled fuel type. */
    private FuelType filledFuelType;
    
    /** Engine type. */
    private EngineType engineType;

    /**
     * Constructor with engine type and fuel type.
     * 
     * @param engineType Engine type
     * @param fuelType Fuel type
     */
    public Engine(EngineType engineType, FuelType fuelType) {
    	this.engineType = engineType;
    	this.requiredFuelType = fuelType;
    }

    /** Starts the engine */
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(filledFuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    /** Stops the engine */
    public void stop() {
        running = false;
    }

    /**
     * Returns flag indicating whether engine is running or not.
     * 
     * @return Flag indicating whether engine is running or not
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Fills engine with the given fuel.
     * 
     * @param fuelType Fuel type
     * @param fuelLevel Fuel level
     */
    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }
        this.filledFuelType = fuelType;
    }

    /**
     * Returns required fuel type.
     * 
     * @return Required fuel type
     */
    public FuelType getFuelType() {
        return requiredFuelType;
    }
    
    /**
     * Returns engine type.
     * 
     * @return Engine type
     */
    public EngineType getEngineType() {
    	return engineType;
    }
    
}
