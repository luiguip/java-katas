package tech.luigui.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BestSumOfKCombinationsTest {

	private static BestSumofKCombinations bestSumofKCombinations;
	private static List<Integer> ls;
	private static List<Integer> indexLs;
	private static Integer[][] indexUnique;
	private static Set<TreeSet<Integer>> treeSetSet;
	private static Integer[][] combinationsFromIndexes;
	private static Set<TreeSet<Integer>> combinationsFromIndexList;
	private static Integer[][] combinationsArr;
	private static Set<TreeSet<Integer>> combinationsList;
	private static Integer[][] combinationsArrk3;
	private static Set<TreeSet<Integer>> combinationstsk3;
	private static Set<List<Integer>> combinationsListk3;
	private static List<Integer> sumsList;
	private static int k;
	
	@BeforeAll
	static void init() {
		bestSumofKCombinations = new BestSumofKCombinations();
		ls = IntStream.range(1,5).boxed().collect(Collectors.toList());
		indexLs = IntStream.range(0,4).boxed().collect(Collectors.toList());
		indexUnique = new Integer[][] {{0}, {1}, {2}, {3}};
		treeSetSet = generateCombinationsList(indexUnique);
		combinationsFromIndexes = new Integer[][] {{1}, {2}, {3}, {4}};
		combinationsFromIndexList = generateCombinationsList(combinationsFromIndexes);
		combinationsArr = new Integer[][] {{0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3}};
		combinationsList = generateCombinationsList(combinationsArr);
		combinationsArrk3 = new Integer[][] {{0,1, 2}, {0,1, 3}, {0, 2, 3}, {1,2, 3}};
		combinationstsk3 = generateCombinationsList(combinationsArrk3);
		combinationsListk3 = generateSetList(combinationstsk3);
		sumsList = IntStream.of(3,4,5,6).boxed().collect(Collectors.toList());
		k = 2;
	}

	private static Set<TreeSet<Integer>> generateCombinationsList(Integer[][] arr) {
		Set<TreeSet<Integer>> combinationsList = Arrays.stream(arr).map(
				xs -> new TreeSet<>(Arrays.asList(xs).stream().collect(Collectors.toSet()))
				).collect(Collectors.toSet());
		return new HashSet<>(combinationsList);
	}
	
	private static Set<List<Integer>> generateSetList(Set<TreeSet<Integer>> setTreeSet) {
		return setTreeSet.stream()
				.map( ts -> ts.stream().collect(Collectors.toList()))
				.collect(Collectors.toSet());
	}
	
	@Test
	void generateIndexListTest() {
		assertEquals(indexLs, bestSumofKCombinations.generateIndexList(ls));
	}
	
	@Test
	void generateSetIndexTreeSetTest() {
		assertEquals(treeSetSet, bestSumofKCombinations.generateSetTreeSet(indexLs));
	}
	
	@Test
	void combineKTimesTestK1() {
		assertEquals(treeSetSet, bestSumofKCombinations.combineKTimes(treeSetSet, indexLs, 1));
	}
	
	@Test
	void combineKTimesTestK3() {
		Set<TreeSet<Integer>> combineKTimes = bestSumofKCombinations.combineKTimes(treeSetSet, indexLs, 3);
		assertEquals(combinationstsk3, combineKTimes);
	}
	
	@Test
	void combineKTimesTestK5Size() {
		List<Integer> ts = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
		Set<TreeSet<Integer>> treeSetSet = bestSumofKCombinations.generateSetTreeSet(ts);
		Set<TreeSet<Integer>> result = bestSumofKCombinations.combineKTimes(treeSetSet, ts, 5);
		result.forEach(
				t -> assertEquals(t.size(), 5));
	}

	@Test
	void combineIterateTest() {
		assertEquals(combinationstsk3, bestSumofKCombinations.combineIterate(treeSetSet, indexLs, 3));
	}

	@Test
	void combineListTest() {
		assertEquals(combinationstsk3, bestSumofKCombinations.combineList(combinationsList, indexLs, 3));
	}
	
	@Test
	void recoverValuesFromIndexesTest() {
		Set<List<Integer>> recoverValuesFromIndexes = bestSumofKCombinations.recoverValuesFromIndexes(combinationstsk3, indexLs);
		combinationsListk3.forEach( combinationFromIndex -> {
			assertTrue(recoverValuesFromIndexes.contains(combinationFromIndex));
			});
		
	}
	
	@Test
	void recoverValuesFromIndexesK5Test() {
		List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
		List<Integer> ls = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6));
		Set<TreeSet<Integer>> treeSetSet = bestSumofKCombinations.generateSetTreeSet(ls);
		Set<TreeSet<Integer>> combinations = bestSumofKCombinations.combineKTimes(treeSetSet, ls, 5);
		Set<List<Integer>> result = bestSumofKCombinations.recoverValuesFromIndexes(combinations, ts);
		result.forEach(
				t -> assertEquals(t.size(), 5));
	}

	@Test
	void sumCombinationsTest() {
		List<Integer> sumCombinations = bestSumofKCombinations.sumCombinations(combinationsListk3);
		sumsList.forEach( sum -> {
			assertTrue(sumCombinations.contains(sum));
		});
	}
	
	@Test
	void chooseClosestSum() {
		assertEquals(6, bestSumofKCombinations.chooseClosestSum(7, sumsList));
	}
	
	@Test
	void chooseClosestSumNull() {
		assertNull(bestSumofKCombinations.chooseClosestSum(1, sumsList));
	}
	
	@Test
	void chooseBestSumTest() {
		assertEquals(9, bestSumofKCombinations.chooseBestSum(10, 3, ls));
	}
	
	@Test
	void chooseBestSumTestNull() {
		assertNull(bestSumofKCombinations.chooseBestSum(7, 5, ls));
	}
	
	@Test
    public void BasicTests1() {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        Integer m = bestSumofKCombinations.chooseBestSum(163, 3, ts);
        assertEquals(163, m);
        ts = new ArrayList<>(Arrays.asList(50));
        m = bestSumofKCombinations.chooseBestSum(163, 3, ts);
        assertEquals(null, m);      
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        m = bestSumofKCombinations.chooseBestSum(230, 3, ts);
        assertEquals(228, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        m = bestSumofKCombinations.chooseBestSum(230, 3, ts);
        assertEquals(228, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        m = bestSumofKCombinations.chooseBestSum(331, 4, ts);
        assertEquals(331, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        m = bestSumofKCombinations.chooseBestSum(70, 4, ts);
        assertNull(m);
	}
	
	@Test
    public void BasicTests2() {
		List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
		Integer m = bestSumofKCombinations.chooseBestSum(331, 5, ts);
        assertNull(m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        m = bestSumofKCombinations.chooseBestSum(331, 5, ts);
        assertNull(m);
    }
	
	@Test
	public void Tests3NoTimeout() {
		Instant start = java.time.Instant.now();
		List<Integer> ts = new ArrayList<>(Arrays.asList(100, 76, 56, 44, 89, 73, 68, 56, 64, 123, 2333, 144, 50, 132, 123, 34, 89));
        Integer m = bestSumofKCombinations.chooseBestSum(230, 4, ts);
        assertEquals(230, m);
        m = bestSumofKCombinations.chooseBestSum(430, 5, ts);
        assertEquals(430, m);
        m = bestSumofKCombinations.chooseBestSum(430, 8, ts);
        assertEquals(null, m);
        Instant end = java.time.Instant.now();
        Duration between = java.time.Duration.between(start, end);
        System.out.println(between.getSeconds());
	}
	
}
