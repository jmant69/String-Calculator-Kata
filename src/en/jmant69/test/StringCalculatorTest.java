package en.jmant69.test;

import org.junit.Assert;
import org.junit.Test;

import en.jmant69.main.StringCalculator;

public class StringCalculatorTest {

	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public final void when1NumberIsUsedThenNoExceptionIsThrown() {
		StringCalculator.add("1");
	}

	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator.add("1,2");
	}

	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(9, StringCalculator.add("3,6"));
	}

	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(62, StringCalculator.add("2,4,8,16,32"));
	}

	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValueIsTheirSum() {
		Assert.assertEquals(14, StringCalculator.add("2,4\n8"));
	}

	@Test
	public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(14, StringCalculator.add("//[;]\n2;4;8")); // Amended to new syntax
	}

	@Test(expected = RuntimeException.class)
	public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		StringCalculator.add("3,-6,15,18,46,33");
	}

	@Test
	public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;
		try {
			StringCalculator.add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	}

	@Test
	public final void whenOneOrMoreNumbersEquals1000IsUsedThenIncludedInSum() {
		Assert.assertEquals(1002, StringCalculator.add("1000,2")); // test the edge of the boundary
	}

	@Test
	public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
		Assert.assertEquals(2, StringCalculator.add("1001,2")); // test greater than the boundary
	}

	@Test
	public final void whenDelimiterOfUnspecifiedLengthIsUsedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(6, StringCalculator.add("//[|||]\n1|||2|||3"));
	}
	
	@Test
	public final void whenMultipleDelimitersOfUnspecifiedLengthAreUsedThenTheyAreUsedToSeparateNumbers() {
		Assert.assertEquals(6, StringCalculator.add("//[|][%]\n1|2%3"));
	}

}