package com.zookeeper;

public class Gorilla extends Mammal {
	
	
	public void throwSomething() {
        System.out.println("Gorilla threw something at people!");
        setEnergy(getEnergy() - 5);
    }

    public void eatBananas() {
        System.out.println("Gorilla ate bananas and regained energy!");
        setEnergy(getEnergy() + 10);
    }

    public void climb() {
        System.out.println("Gorilla climbed a tree!");
        setEnergy(getEnergy() - 10);
    }

}
