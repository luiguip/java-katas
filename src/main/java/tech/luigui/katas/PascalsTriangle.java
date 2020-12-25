package tech.luigui.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PascalsTriangle {
	
	public long[] generate(int level) {
		List<Long[]> triangle = generateInitialPascalsTriangle();
	    for(int iLevel = 0; iLevel < level-1; iLevel++) {
	    	  Long[] row = addRow(triangle.get(iLevel));
	    	  triangle.add(row);
	    }
	    return formatResult(triangle);
	}

	public List<Long[]> generateInitialPascalsTriangle() {
		List<Long[]> firstRow = new ArrayList<>();
		firstRow.add(new Long[] {1L});
		return firstRow;
	}

	public Long[] addRow(Long[] lastRow) {
		Long[] row = new Long[lastRow.length + 1];
		for(int i=0; i<row.length; i++) {
			if(i == 0) {
				row[i] = lastRow[i];
			} else if(i == row.length-1) {
				row[i] = lastRow[i-1];
			} else {
				row[i] = lastRow[i-1] + lastRow[i];
			}
		}
		return row;
	}

	public long[] formatResult(List<Long[]> triangle) {
		return triangle.stream()
				.flatMap(Stream::of)
				.mapToLong(Long::longValue)
				.toArray();
	}
	
//	public int[][] formatResult2(List<Long[]> triangle) {
//		return triangle.stream()
//				.map(longArray -> Stream.of(longArray).mapToInt(Math::toIntExact).toArray())
//				.toArray();
//	}
}
