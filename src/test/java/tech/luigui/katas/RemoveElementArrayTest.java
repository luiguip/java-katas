package tech.luigui.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
public class RemoveElementArrayTest {

	private RemoveElementArray removeElementArray = new RemoveElementArray();
	private int[] arr;
	private Map<Integer, List<Integer>> numbersMap;
    private List<Integer> numberslist;
    private List<BigDecimal> subSumList;
    private List<BigDecimal> subProductList;
    private Map<Integer, BigDecimal> minorQuotientsMapTest = new HashMap<>();
    private Map<Integer, BigDecimal> quotientsMap = new HashMap<>();
    int[][] resultsTest;
    
    @BeforeEach
    void init() {
    	arr = IntStream.of(23, 2, -8, 5).toArray();
    	numbersMap = generateNumbersMap(arr);
    	subSumList = numbersMap
			    			.values()
			    			.stream()
			    			.map(list -> new BigDecimal(list.stream().mapToInt(Integer::intValue).sum()))
			    			.collect(Collectors.toList());
    	subProductList = numbersMap
    						.values()
			    			.stream()
			    			.map(list -> new BigDecimal(list.stream().reduce(1, (x, y) -> x*y)))
			    			.collect(Collectors.toList());
    	IntStream
    			.range(0,subProductList.size())
    			.forEach(i -> quotientsMap.put(i, 
    					subProductList.get(i).divide(subSumList.get(i), 6, RoundingMode.CEILING).abs()));
    	minorQuotientsMapTest.put(2, quotientsMap.get(2));
    	resultsTest = new int[][] {{2, arr[2]}};
    }
     
    @Test
    void generateNumbersMapTest() {
        Map<Integer, List<Integer>> generatedNumbersMap = removeElementArray.generateNumbersMap(arr);
        IntStream.range(0,5).forEach(
        		i -> assertEquals(numbersMap.get(i), generatedNumbersMap.get(i)));
    }
 
    private Map<Integer, List<Integer>> generateNumbersMap(int[] arr) {
    	Map<Integer, List<Integer>> numbersMap = new HashMap<>();
    	int count = 0;
    	for(int i : arr) {
    		List<Integer> row = IntStream.of(arr).filter(j -> j != i).boxed().collect(Collectors.toList());
    		numbersMap.put(count, row);
    		count ++;
    	}
        return numbersMap;
    }
    
    @Test
    void testCalculateQuoficient() {
    	List<Integer> numbersList = IntStream.of(23, 2, -8, 5).boxed().collect(Collectors.toList());
    	BigDecimal absSubSum = new BigDecimal(22);
    	BigDecimal absSubProduct = new BigDecimal(-1840);
    	BigDecimal quotient = absSubProduct.divide(absSubSum, 6, RoundingMode.CEILING);
    	
    	assertEquals(quotient.abs(), removeElementArray.caculateQuotient(numbersList));
    }
    
    @Test
    void testZeroSubSumQuoficient() {
    	List<Integer> numbersList = IntStream.of(1, 2, -8, 5).boxed().collect(Collectors.toList());
    	assertThrows(ArithmeticException.class, () -> removeElementArray.caculateQuotient(numbersList));
    }
    
    @Test
    void testCalculateCoeficients() {
    	Map<Integer, List<Integer>> numbersMap = this.numbersMap;
    	Map<Integer, BigDecimal> quotients = this.quotientsMap;
    	Map<Integer, BigDecimal> calculateQuotients = removeElementArray.calculateQuotients(numbersMap);
    	IntStream.range(0, quotients.size()).forEach(
    			i -> assertEquals(quotients.get(i), calculateQuotients.get(i)));
    }
    
    @Test
    void testMinorQuotientsMap() {
    	Map<Integer, BigDecimal> minorQuotientsMap = removeElementArray.calculateMinorQuotientMap(quotientsMap);
    	IntStream.range(0, minorQuotientsMap.size()).forEach(
    			i -> assertEquals(minorQuotientsMap.get(i), minorQuotientsMapTest.get(i)));
    }

    @Test
    void testGenerateMatrixMinorQuotientsRemovedMember() {
    	int[][] results = removeElementArray.generateMatrixMinorQuotientsRemovedMember(minorQuotientsMapTest, arr);
    	 IntStream.range(0,results.length).forEach(
         		i -> assertTrue(Arrays.equals(results[i], resultsTest[i])));
    }
    
    @Test
    void testCalculateTheMinorQuotientRemovedMember() {
    	int[][] results = removeElementArray.calculateTheMinorQuotientRemovedMember(arr, minorQuotientsMapTest);
    	 IntStream.range(0,results.length).forEach(
          		i -> assertTrue(Arrays.equals(results[i], resultsTest[i])));
    }
    
    @Test
    void testSelectSubArray() {
    	int[][] results = removeElementArray.selectSubarray(arr);
   	 	IntStream.range(0,results.length).forEach(
         		i -> assertTrue(Arrays.equals(results[i], resultsTest[i])));
    }
    
    @Test
    void testSelectSubArrayCaseTwoResults() {
    	int[] arr = IntStream.of(10, 20, -30, 100, 200).toArray();
    	int[][] expectedResult = new int[][]{{3, 100}, {4,200}};
    	int[][] results = removeElementArray.selectSubarray(arr);
   	 	IntStream.range(0,results.length).forEach(
         		i -> assertTrue(Arrays.equals(expectedResult[i], results[i])));
    }
    
    @Test
    void testSelectSubArrayTestCase2() {
    	int[] arr = IntStream.of(1, 3, 23, 4, 2, -8, 5, 18).toArray();
    	int[][] expectedResult = new int[][]{{2, 23}};
    	int[][] results = removeElementArray.selectSubarray(arr);
   	 	IntStream.range(0,results.length).forEach(
         		i -> assertTrue(Arrays.equals(expectedResult[i], results[i])));
    }
    
    @Test
    void testSelectSubArrayTestCase3() {
    	int[] arr = IntStream.of(1, -1, 2, -2).toArray();
    	int[][] expectedResult = new int[][]{{2, 2}, {3, -2}};
    	int[][] results = removeElementArray.selectSubarray(arr);
   	 	IntStream.range(0,results.length).forEach(
   	 		i -> assertTrue(Arrays.equals(expectedResult[i], results[i])));
    }
    
    @Test
    void testeSelectSubArrayTestCaseDeep() {
    	int[] arr = IntStream.of(-161,-131,-164,-172,115,19,183,-118,77,-91,-174,-120,-109,-32,197,-156,
    			-93,114,163,-8,-123,96,-94,-115,-3,-170,-184,-7,21,161,135,108,55,-12,143,5,119,82,-67,
    			-106,-49,-57,179,150,40,-68,-85,193,152,148,66,167,-186,65,11,162,-146,-54,-34,141,-64,
    			128,39,87,48,-38,-127,-147,-89,8,15,-27)
    		.toArray();
		int[][] expectedResult = new int[][]{{14, 197}, {52, -186}};
		int[][] results = removeElementArray.selectSubarray(arr);
	 	IntStream.range(0,results.length).forEach(
	 		i -> assertTrue(Arrays.equals(expectedResult[i], results[i])));
    }
}
