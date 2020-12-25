package tech.luigui.katas;

import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.jupiter.api.Test;

class PascalsTriangleTest {
	PascalsTriangle pascalsTriangle = new PascalsTriangle();
	
	@Test
	void generateInitialPascalsTriangleTest() {
		List<Long[]> result = pascalsTriangle.generateInitialPascalsTriangle();
		List<Long[]> expected = Arrays.asList(new Long[][] {{1L}});
		assertThat(expected.get(0), is(result.get(0)));
	}
	
	@Test
	void addRowTest() {
		Long[] row0 = new Long[]{ 1L };
		Long[] row1 = new Long[]{ 1L, 1L };
		Long[] row2 = new Long[]{ 1L, 2L, 1L };
		Long[] row3 = new Long[]{ 1L, 3L, 3L, 1L };
		assertThat(pascalsTriangle.addRow(row0), is(row1));
		assertThat(pascalsTriangle.addRow(row1), is(row2));
		assertThat(pascalsTriangle.addRow(row2), is(row3));
	}

	@Test
	void formatResult() {
		Long[] row0 = new Long[]{ 1L };
		Long[] row1 = new Long[]{ 1L, 1L };
		Long[] row2 = new Long[]{ 1L, 2L, 1L };
		List<Long[]> triangle = new ArrayList<>();
		triangle.add(row0);
		triangle.add(row1);
		triangle.add(row2);
		Long[] expected = new Long[] {1L, 1L, 1L, 1L, 2L, 1L};
		assertThat(pascalsTriangle.formatResult(triangle), is(expected));
	}

	@Test
    void testOneLevelTriangle() {
        final Long[] terms = { 1L };
        assertThat(pascalsTriangle.generate(1), is(terms));
    }

    @Test
    void testTwoLevelsTriangle() {
        final Long[] terms = { 1L, 1L, 1L };
        assertThat(pascalsTriangle.generate(2), is(terms));
    }
  
    @Test
    void testFourLevelsTriangle() {
        final Long[] terms = { 1L, 1L, 1L, 1L, 2L, 1L, 1L, 3L, 3L, 1L };
        assertThat(pascalsTriangle.generate(4), is(terms));
    }
}
