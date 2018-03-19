package validation;

public class ArrayValidator {

	public static boolean areAllFalse(boolean[] array) {
		for (boolean b : array)
			if (b)
				return false;
		return true;
	}
	
	public static boolean isMoreThanOneTrue(boolean[] array) {
		int count = 0;
		for (boolean b : array)
			if (b)
				count++;
		return count > 1 ? true : false;
	}

}
