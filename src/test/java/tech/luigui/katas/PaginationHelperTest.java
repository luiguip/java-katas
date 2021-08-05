package tech.luigui.katas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static java.util.stream.Collectors.toList;

class PaginationHelperTest {

    List<Integer> coll = IntStream.range(0,103).boxed().collect(toList());
    PaginationHelper<Integer> paginationHelper = new PaginationHelper<>(coll, 10);

    @Test
    void itemCountTest() {
        assertThat(paginationHelper.itemCount(), is(coll.size()));
    }

    @Test
    void pageCountTest() {
        assertThat(paginationHelper.pageCount(), is(11));
    }

    @Test
    void pageItemCountTest() {
        assertThat(paginationHelper.pageItemCount(-10), is(-1));
        assertThat(paginationHelper.pageItemCount(0), is(10));
        assertThat(paginationHelper.pageItemCount(10), is(3));
    }

    @Test
    void pageIndexTest() {
        assertThat(paginationHelper.pageIndex(-5), is(-1));
        assertThat(paginationHelper.pageIndex(0), is(0));
        assertThat(paginationHelper.pageIndex(50), is(5));
        assertThat(paginationHelper.pageIndex(101), is(10));
    }
}
