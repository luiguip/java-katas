package tech.luigui.katas;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.*;

public class RemoveElementArray {
	
    public int[][] selectSubarray(final int[] arr) {
        Map<Integer, List<Integer>> numbersMap = generateNumbersMap(arr);
        Map<Integer, BigDecimal> quotientsMap = calculateQuotients(numbersMap);
        return calculateTheMinorQuotientRemovedMember(arr, quotientsMap);
    }
 
    public Map<Integer, List<Integer>> generateNumbersMap(int[] arr) {
    	Map<Integer, List<Integer>> numberMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
        	List<Integer> numbersList = IntStream.of(arr).boxed().collect(Collectors.toList());
        	numbersList.remove(i);
            numberMap.put(i, numbersList);
        }
        return numberMap;
    }
 
    public Map<Integer, BigDecimal> calculateQuotients(Map<Integer, List<Integer>> numbersMap) {
    	Map<Integer, BigDecimal> quotients = new HashMap<>();
        for(int key: numbersMap.keySet()) {
        	try {
        		List<Integer> numbersList = numbersMap.get(key);
        		BigDecimal quotient = caculateQuotient(numbersList);
        		quotients.put(key, quotient);
        	} catch(ArithmeticException ae) {
        		
        	}
        }
        return quotients;
    }
    
    public BigDecimal caculateQuotient(List<Integer> numbersList) {
    	BigDecimal subSumBigDecimal = new BigDecimal(0);
    	BigDecimal subProductBigDecimal = new BigDecimal(1);
    	for(int i=0; i< numbersList.size(); i++) {
    		subSumBigDecimal = subSumBigDecimal.add(new BigDecimal(numbersList.get(i)));
    		subProductBigDecimal = subProductBigDecimal.multiply(new BigDecimal(numbersList.get(i)));
    	}
    	BigDecimal quotient = subProductBigDecimal.divide(subSumBigDecimal, 6, RoundingMode.CEILING);
    	return quotient.abs();
    }
    
    public int[][] calculateTheMinorQuotientRemovedMember(int[] arr, Map<Integer, BigDecimal> quotientsMap) {
    	Map<Integer, BigDecimal> minQuotientsMap = calculateMinorQuotientMap(quotientsMap);
    	return generateMatrixMinorQuotientsRemovedMember(minQuotientsMap, arr);
    }
    
    public Map<Integer, BigDecimal> calculateMinorQuotientMap(Map<Integer, BigDecimal> quotientsMap) {
    	Collection<BigDecimal> quotientsValues = quotientsMap.values();
    	BigDecimal min = Collections.min(quotientsValues);
    	List<Integer> keysToRemove = new ArrayList<>();
    	for(int i: quotientsMap.keySet()) {
    		if(!quotientsMap.get(i).equals(min)) {
    			keysToRemove.add(i);
    		}
    	}
    	keysToRemove.forEach(quotientsMap::remove);
    	return quotientsMap;
    }
    
    public int[][] generateMatrixMinorQuotientsRemovedMember(Map<Integer, BigDecimal> minQuotientsMap, int[] arr) {
    	int[][] results = new int[minQuotientsMap.size()][2];
    	List<Integer> keysList = List.copyOf(minQuotientsMap.keySet());
    	for(int i=0; i< keysList.size(); i++) {
    		results[i][0] = keysList.get(i).intValue();
    		results[i][1] = arr[keysList.get(i)];
    	}
    	return results;
    }
}
