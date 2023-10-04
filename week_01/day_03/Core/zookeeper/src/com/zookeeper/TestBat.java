package com.zookeeper;

public class TestBat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bat batman = new Bat();
		batman.displayEnergy();
		for (int i = 0; i < 3; i++) {
			batman.attackTown();
			batman.displayEnergy();
        }
		
		for (int i = 0; i < 2; i++) {
			batman.eatHumans();
			batman.displayEnergy();
        }

        for (int i = 0; i < 2; i++) {
        	batman.fly();
        	batman.displayEnergy();
        }

        batman.displayEnergy();
	}

}
