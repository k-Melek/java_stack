package com.zookeeper;

public class Mammal {
	private int energy;
	
	
	
	public Mammal() {
		this.energy = 100;
	}

	// method
	
	 public int displayEnergy() {
	        System.out.println("Energy level: " + getEnergy());
	        return getEnergy();
	    }
	
	// getter setter

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	

}
