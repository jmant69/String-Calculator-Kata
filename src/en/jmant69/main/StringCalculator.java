package en.jmant69.main;

public class StringCalculator {

	public static int add(final String numbers) {
		int sum = 0;
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
		} else {
			for (String number : numbersArray) {
				if (!number.isEmpty()) {
					sum += Integer.parseInt(number);
				}
			}
		}
		return sum;
	}

}
