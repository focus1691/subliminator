package utility;

import java.util.Random;

public class RandomNumberGenerator {
	
	public static synchronized int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
