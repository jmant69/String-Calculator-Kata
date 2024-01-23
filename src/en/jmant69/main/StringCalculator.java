package en.jmant69.main;

public class StringCalculator {

	public static int add(final String numbers) {
		String delimiter = ",|\n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);	
		}
		return add(numbersWithoutDelimiter, delimiter);
	}
	
	private static int add(final String numbers, final String delimiter) {
		int sumOfNumbers = 0; //Changed 'sum' to a more meaningful field name
		String[] numbersArray = numbers.split(delimiter); //Changed to use the delimiter variable
		for (String number : numbersArray) {
			if (!number.isEmpty()) {
				sumOfNumbers += Integer.parseInt(number);
			}
		}
		return sumOfNumbers;		
	}

}
