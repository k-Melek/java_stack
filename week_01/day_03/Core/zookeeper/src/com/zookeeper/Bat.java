package com.zookeeper;

public class Bat extends Mammal {
	public Bat() {
        setEnergy(300);
    }
	
	public void fly() {
        System.out.println("Bat is flying!");
        setEnergy(getEnergy() - 50);
    }

    public void eatHumans() {
        System.out.println("Bat is eating humans!");
        setEnergy(getEnergy() + 25);
    }

    public void attackTown() {
        System.out.println("Bat is attacking the town!");
        setEnergy(getEnergy() - 100);
    }
}
