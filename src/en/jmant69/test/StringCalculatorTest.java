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
	
	@Test(expected = RuntimeException.class)
	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
		StringCalculator.add("1,2,3");
	}	
	
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator.add("3"));
	}

	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator.add("3,6"));
	}

}