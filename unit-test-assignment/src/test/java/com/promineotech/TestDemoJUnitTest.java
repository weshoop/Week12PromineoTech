package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(()->
			testDemo.addPositive(a,b))
				.isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
		arguments(2, 4, 6, false),
		arguments(1, 4, 5, false),
		arguments(0, 3, 3, true),
		arguments(-1, 5, 4, true),
		arguments(3, -2, 1, true),
		arguments(0, 0, 0, true),
		arguments(-3, 4, -6, true)
	);		
		
	}
	
	@Test
	
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	
			assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
			assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
			assertThat(testDemo.addPositive(22, 23)).isEqualTo(45);
			assertThat(testDemo.addPositive(17, 14)).isEqualTo(31);
		}
	
	
	// Test for the multiply method in TestDemo class.
	// It tests various positive (and one negative) multiplication cases.
	
	@Test
	
	void assertThatNumbersAreMultipliedCorrectly() {
		
		assertThat(testDemo.multiplyNumbers(2, 3)).isEqualTo(6);
		assertThat(testDemo.multiplyNumbers(4, 5)).isEqualTo(20);
		assertThat(testDemo.multiplyNumbers(0, 7)).isEqualTo(0);
		assertThat(testDemo.multiplyNumbers(-2, 3)).isEqualTo(-6);
		
		
	}
	
	@Test
	
	void assertThatNumberSquaredIsCorrect() {
		
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
		
	}
	}

