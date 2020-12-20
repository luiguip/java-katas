package tech.luigui.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestSumofKCombinations {

	public Integer chooseBestSum(int t, int k, List<Integer> ls) {
		if(invalidParameters(k, ls))
			return null;
		List<Integer> indexList = generateIndexList(ls);
		Set<TreeSet<Integer>> setTreeSet = generateSetTreeSet(indexList);
		Set<TreeSet<Integer>> combinationsIndex = combineKTimes(setTreeSet, indexList, k);
		Set<List<Integer>> combinations = recoverValuesFromIndexes(combinationsIndex, ls);
		List<Integer> sumList = sumCombinations(combinations);
		return chooseClosestSum(t, sumList);
	}
	
	

	private boolean invalidParameters(int k, List<Integer> ls) {
		if(k >ls.size())
			return true;
		return false;
	}

	public List<Integer> generateIndexList(List<Integer> ls) {
		return IntStream.range(0, ls.size()).mapToObj(Integer::valueOf).collect(Collectors.toList());
	}
	
	public Set<TreeSet<Integer>> generateSetTreeSet(List<Integer> indexList) {
		Set<TreeSet<Integer>> setTreeSet = new HashSet<>();
		indexList.forEach( i -> {
			TreeSet<Integer> treeSet = new TreeSet<>();
			treeSet.add(i);
			setTreeSet.add(treeSet);
			});
		return setTreeSet;
	}

	public Set<TreeSet<Integer>> combineKTimes(Set<TreeSet<Integer>> treeSetSet, List<Integer> indexLs, int k) {
		if(k > indexLs.size() /2) {
			Integer numberOfElementsToRemove = indexLs.size() - k;
			Set<TreeSet<Integer>> toRemove = combineIterate(treeSetSet, indexLs, numberOfElementsToRemove);
			return removeElementsHighK(indexLs, toRemove);
		} else if(k > 1) {
			return combineIterate(treeSetSet, indexLs, k);
		}
		return treeSetSet;
		
	}

	public Set<TreeSet<Integer>> combineIterate(Set<TreeSet<Integer>> setToCombine, List<Integer> indexList, int k) {
		Set<TreeSet<Integer>> newSetCombined = new HashSet<>(setToCombine);
		for(int i = 2; i<=k ;i++) {
			newSetCombined = combineList(newSetCombined, indexList, i);
		}
		return newSetCombined;
	}
	
	private Set<TreeSet<Integer>> removeElementsHighK(List<Integer> indexLs, Set<TreeSet<Integer>> toRemove) {
		Set<TreeSet<Integer>> setTreeSetRemoved = new HashSet<>();
		toRemove.forEach( ts -> {
			TreeSet<Integer> treeSetRemoved = indexLs.stream()
					.filter(x -> !ts.contains(x))
					.collect(Collectors.toCollection(() -> new TreeSet<Integer>()));
			setTreeSetRemoved.add(treeSetRemoved);
		});
		return setTreeSetRemoved;
	}

	public Set<TreeSet<Integer>> combineList(Set<TreeSet<Integer>> setToCombine, List<Integer> indexList, int k) {
		Set<TreeSet<Integer>> newSetCombined = new HashSet<>();
		for(Integer index: indexList) {
			newSetCombined = combineIndex(setToCombine, k, newSetCombined, index);
		}
		return newSetCombined;
	}

	private Set<TreeSet<Integer>> combineIndex(Set<TreeSet<Integer>> setToCombine, int k, Set<TreeSet<Integer>> newSetCombined,
			Integer index) {
		for(TreeSet<Integer> l: setToCombine) {
			if(l.size() < k) {
				newSetCombined = combine(k, newSetCombined, index, l);
			}
		}
		return newSetCombined;
	}

	private Set<TreeSet<Integer>> combine(int k, Set<TreeSet<Integer>> newSetCombined, Integer index, TreeSet<Integer> l) {
		TreeSet<Integer> treeSetToAdd = new TreeSet<>(l);
		treeSetToAdd.add(index);
		if(treeSetToAdd.size() == k) {
			newSetCombined.add(treeSetToAdd);
		}
		return newSetCombined;
	}
	
	public Set<List<Integer>> recoverValuesFromIndexes(Set<TreeSet<Integer>> combinationsIndex, List<Integer> ls) {
		Set<List<Integer>> combinations = new HashSet<>();
		combinationsIndex.forEach( ts -> {
			List<Integer> integerList = new LinkedList<>();
			ts.forEach(i -> integerList.add(ls.get(i)));
			combinations.add(integerList);
		});
		return combinations;
	}

	public List<Integer> sumCombinations(Set<List<Integer>> combinationsSet) {
		return combinationsSet.stream()
				.map(t -> t.stream().reduce(0, (x,y) -> x+y))
				.collect(Collectors.toList());
	}

	public Integer chooseClosestSum(int t, List<Integer> sumsList) {
		return sumsList.stream().filter(a -> a <= t).max(Integer::compare).orElse(null);
	}
}
