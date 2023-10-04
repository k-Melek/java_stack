package com.cardrive.melek;

public class Car {
	private Integer gas;
	
	
	
	// constructor
	
	public Car() {
		this.gas = 10;
	}
	
	// methods 
	public void displayGas() {
        System.out.println("Gas remaining: " + gas);
    }

	// getters setters

	public Integer getGas() {
		return gas;
	}

	public void setGas(Integer gas) {
        if (gas >= 0) {
            this.gas = gas;
        } else {
            System.out.println("Game over");
        }
	}
	
}
