package tech.luigui.katas;

import java.util.stream.IntStream;

public class MultipleOf3And5 {

	public static int solution(int number) {
		return IntStream
				.range(1, number)
				.filter(i -> i % 3 == 0 || i % 5 == 0)
				.sum();
	}
}
