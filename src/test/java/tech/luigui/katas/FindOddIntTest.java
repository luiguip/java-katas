package tech.luigui.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindOddIntTest {

	private static FindOddInt findOddInt;
	private static int[] arr;
	private static Map<Integer, Long> countMap;
	private static int result;

	@BeforeAll
	static void init() {
		findOddInt = new FindOddInt();
		arr = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
		countMap = generateCountMap();
		result = 5;
	}
	
	private static Map<Integer, Long> generateCountMap() {
		Map<Integer, Long> countMap = new HashMap<>();
		countMap.put(-2, 2L);
		countMap.put(-1, 2L);
		countMap.put(1, 2L);
		countMap.put(2,2L);
		countMap.put(3, 2L);
		countMap.put(4, 2L);
		countMap.put(5, 3L);
		countMap.put(20, 2L);
		return countMap;
		
	}
	
	@Test
	void generateCountMapTest() {
		assertEquals(countMap, findOddInt.generateCountMap(arr));
	}
	
	@Test
	void getOddNumberFromCountMap() {
		assertEquals(result, findOddInt.getOddNumberFromCountMap(countMap));
	}

	@Test
	void testCaseDefault() {
		assertEquals(result, findOddInt.result(arr));
	}
}
