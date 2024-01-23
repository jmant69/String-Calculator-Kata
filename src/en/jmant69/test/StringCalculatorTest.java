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

}