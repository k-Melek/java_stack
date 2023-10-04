package com.cardrive.melek;

public class Driver extends Car {

	public void drive() {
		if (getGas() >= 1) {
			setGas(getGas() - 1);
			System.out.println("Driving. Gas remaining: " + getGas() + " gallons");
		} else {
			System.out.println("Not enough gas to drive. Gas remaining: " + getGas() + " gallons");
		}
	}

	public void useBoosters() {
		if (getGas() >= 3) {
			setGas(getGas() - 3);
			System.out.println("Using boosters. Gas remaining: " + getGas() + " gallons");
		} else {
			System.out.println("Not enough gas to use boosters. Gas remaining: " + getGas() + " gallons");
		}
	}

	public void refuel() {
		if (getGas() < 8) {

			setGas(getGas() + 2);
			System.out.println("Refueling. Gas remaining: " + getGas() + " gallons");
		} else {
			System.out.println(
					"Gas level is already sufficient. No need to refuel. Gas remaining: " + getGas() + " gallons");
		}
	}
}
