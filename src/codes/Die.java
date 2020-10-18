package codes;

import java.util.Random;

public class Die {
	//
	private int dieSide;
	//
	public int scoreThrow() {
		Random rndmGenerator = new Random();
		dieSide = rndmGenerator.nextInt(6) + 1;
		return dieSide;
	}
}
