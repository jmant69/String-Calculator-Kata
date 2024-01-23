package en.jmant69.main;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(final String numbers) {
		String delimiter = ",|\n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("[");
			int delimiterEndIndex = numbers.indexOf("\n");
			delimiter = numbers.substring(delimiterIndex, delimiterEndIndex);
			delimiter = delimiter.replace("][", "");
			numbersWithoutDelimiter = numbers.substring(delimiterEndIndex + 1);
		}
		return add(numbersWithoutDelimiter, delimiter);
	}

	private static int add(final String numbers, final String delimiter) {
		int sumOfNumbers = 0;
		String[] numbersArray = numbers.split(delimiter);
		List<Integer> negativeNumbers = new ArrayList<Integer>();
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				int numberInt = Integer.parseInt(number);
				if (numberInt < 0) {
					negativeNumbers.add(numberInt);
				} else if (numberInt <= 1000) {
					sumOfNumbers += numberInt;
				}
			}
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		}
		return sumOfNumbers;
	}

}
