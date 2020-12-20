package tech.luigui.katas;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOddInt {

	public int result(int[] arr) {
		Map<Integer, Long> countMap = generateCountMap(arr);
		return getOddNumberFromCountMap(countMap);
	}
	
	public Map<Integer, Long> generateCountMap(int[] arr) {
		return IntStream.of(arr)
				.boxed()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
	}

	public Integer getOddNumberFromCountMap(Map<Integer, Long> countMap) {
		return countMap.entrySet()
					.stream()
					.filter(e -> e.getValue() % 2 != 0)
					.mapToInt(Map.Entry::getKey)
					.findFirst()
					.getAsInt();
	}
}
